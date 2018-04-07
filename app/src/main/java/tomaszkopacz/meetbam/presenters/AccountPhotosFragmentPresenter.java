package tomaszkopacz.meetbam.presenters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tomaszkopacz.meetbam.activities.AccountPhotosFragment;
import tomaszkopacz.meetbam.model.Post;
import tomaszkopacz.meetbam.service.LoginService;
import tomaszkopacz.meetbam.service.PostAdapter;
import tomaszkopacz.meetbam.service.PostTimeProvider;
import tomaszkopacz.meetbam.service.PostViewHolder;
import tomaszkopacz.meetbam.service.WebService;

/**
 * Created by tomas on 02.03.2018.
 */

public class AccountPhotosFragmentPresenter implements RecyclerViewPresenter{

    private AccountPhotosFragment fragment;
    private WebService mWebService;
    private LoginService mLoginService;

    // photos list
    private PostAdapter adapter;
    private List<Post> photos = new ArrayList<>();

    // photo base url
    private static final String BASE_URL = "http://meetbam.cba.pl/";

    /**
     * Constructor.
     */
    public AccountPhotosFragmentPresenter(AccountPhotosFragment fragment, WebService service){
        this.fragment = fragment;
        this.mWebService = service;
        this.mLoginService = new LoginService(fragment.getActivity().getApplicationContext());
        this.adapter = new PostAdapter(this);
    }

    /**
     * Downloads posts and send them to activity.
     */
    public void downloadPostsList(){

        // remove previous elements
        photos.clear();

        // when the elements downloaded
        Call call = mWebService.getUserPosts(mLoginService.getUserMail());
        call.enqueue(new Callback<List<Post>>() {

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                // assign response objects to list
                photos = response.body();

                // send posts to activity
                fragment.putPhotos(adapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemBoundAtPosition(RecyclerView.ViewHolder holder, int position) {
        Post post = photos.get(position);

        //set text views
        ((PostViewHolder) holder).getName1().setText(post.getName1() + " " + post.getSurname1());
        ((PostViewHolder) holder).getName2().setText(post.getName2() + " " + post.getSurname2());

        // download and set image
        Glide
                .with(fragment)
                .load(BASE_URL + post.getPhotoDir())
                .into(((PostViewHolder) holder).getPhoto());

        // count time since post was uploaded
        float timeAgo = PostTimeProvider.countTimeAgo(post.getTime());

        // get appropriate info about how long ago post was uploaded
        String timeAgoText = PostTimeProvider.getTimeAgoText(timeAgo);
        ((PostViewHolder) holder).getTime().setText(timeAgoText);
    }

    @Override
    public void onItemClick(View view) {

    }

    @Override
    public int getItemCount() {
        return photos.size();
    }
}
