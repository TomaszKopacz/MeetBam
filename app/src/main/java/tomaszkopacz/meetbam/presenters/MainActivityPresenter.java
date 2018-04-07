package tomaszkopacz.meetbam.presenters;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tomaszkopacz.meetbam.activities.AcceptPhotoDialog;
import tomaszkopacz.meetbam.activities.LoginActivity;
import tomaszkopacz.meetbam.activities.MainActivity;
import tomaszkopacz.meetbam.model.Post;
import tomaszkopacz.meetbam.service.CameraService;
import tomaszkopacz.meetbam.service.LoginService;
import tomaszkopacz.meetbam.service.PostAdapter;
import tomaszkopacz.meetbam.service.PostTimeProvider;
import tomaszkopacz.meetbam.service.PostViewHolder;
import tomaszkopacz.meetbam.service.WebService;

/**
 * Created by tomas on 03.03.2018.
 */

public class MainActivityPresenter implements RecyclerViewPresenter{

    private MainActivity activity;
    private WebService mWebService;
    private LoginService mLoginService;

    // posts list
    private PostAdapter adapter;
    private List<Post> posts = new ArrayList<>();

    // photo base url
    private static final String BASE_URL = "http://meetbam.cba.pl/";

    // photo storage directory
    private static final String PHOTO_DIRECTORY
            = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES) + "/Meetbam/";
    private Uri photoUri;

    private AcceptPhotoDialog dialog;

    /**
     * Constructor.
     */
    public MainActivityPresenter(MainActivity activity, WebService service){
        this.activity = activity;
        this.mWebService = service;
        this.mLoginService = new LoginService(activity.getApplicationContext());
        this.adapter = new PostAdapter(this);
    }

    /**
     * Logout. Clears SharedPreferences and switches view to LoginActivity.
     */
    public void logout(){

        // logout the user
        mLoginService.logout();

        // switch view to LoginActivity
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    /**
     * Downloads posts and send them to activity.
     */
    public void downloadPostsList(){

        // remove previous elements
        posts.clear();

        // when new elements downloaded
        Call call = mWebService.getFriendsPosts(mLoginService.getUserMail());
        call.enqueue(new Callback<List<Post>>() {

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                // assign response objects to list
                posts = response.body();

                // send posts to activity
                activity.putPosts(adapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemBoundAtPosition(RecyclerView.ViewHolder holder, int position) {
        Post post = posts.get(position);

        //set text views
        ((PostViewHolder) holder).getName1().setText(post.getName1() + " " + post.getSurname1());
        ((PostViewHolder) holder).getName2().setText(post.getName2() + " " + post.getSurname2());
        //((PostViewHolder) holder).getTime().setText(post.getTime());

        // download and set image
        Glide
                .with(activity)
                .load(BASE_URL + post.getPhotoDir())
                .into(((PostViewHolder) holder).getPhoto());

        // count time since post was uploaded
        float timeAgo = PostTimeProvider.countTimeAgo(post.getTime());

        // get appropriate info about how long ago post was uploaded
        String timeAgoText = PostTimeProvider.getTimeAgoText(timeAgo);
        ((PostViewHolder) holder).getTime().setText(timeAgoText);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    /**
     * Starts camera. Creates file for available photo.
     */
    public void makePhoto(){

        // create file to store photo
        String photoFileName
                = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + ".jpg";
        File photoFile = CameraService.getFileForDirectory(PHOTO_DIRECTORY, photoFileName);

        // set uri of file created
        photoUri = Uri.fromFile(photoFile);

        // open camera activity
        if (photoFile != null){
            Intent cameraIntent = CameraService.getCameraIntent(photoFile);
            activity.startActivityForResult(cameraIntent, activity.CAMERA_CODE);
        }
    }

    /**
     * Show dialog to accept picture and pair with new person.
     */
    public void showAcceptPhotoDialog(){

        // new dialog
        dialog = new AcceptPhotoDialog(activity, this);

        // load photo
        dialog.loadPhoto(photoUri);

        // show dialog
        dialog.show();
    }

    /**
     * Pair with a new person.
     */
    public void pair(){
        dialog.getPersonTextView().setText("ZBYSZEK");
    }
}
