package tomaszkopacz.meetbam.presenters;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tomaszkopacz.meetbam.activities.AccountPhotosFragment;
import tomaszkopacz.meetbam.model.Post;
import tomaszkopacz.meetbam.service.LoginService;
import tomaszkopacz.meetbam.service.WebService;

/**
 * Created by tomas on 02.03.2018.
 */

public class AccountPhotosFragmentPresenter {

    private AccountPhotosFragment fragment;
    private WebService mWebService;
    private LoginService mLoginService;

    private List<Post> posts = new ArrayList<>();

    /**
     * Constructor.
     */
    public AccountPhotosFragmentPresenter(AccountPhotosFragment fragment, WebService service){
        this.fragment = fragment;
        this.mWebService = service;
        this.mLoginService = new LoginService(fragment.getActivity().getApplicationContext());
    }

    /**
     * Downloads posts and send them to activity.
     */
    public void downloadPostsList(){

        // remove previous elements
        posts.clear();

        // when the elements downloaded
        Call call = mWebService.getUserPosts(mLoginService.getUserMail());
        call.enqueue(new Callback<List<Post>>() {

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                // assign response objects to list
                posts = response.body();

                // send posts to activity
                fragment.setUpList(posts);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}
