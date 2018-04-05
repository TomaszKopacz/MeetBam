package tomaszkopacz.meetbam.presenters;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.IOException;
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
import tomaszkopacz.meetbam.service.WebService;

/**
 * Created by tomas on 03.03.2018.
 */

public class MainActivityPresenter {

    private MainActivity activity;
    private WebService service;

    private List<Post> posts = new ArrayList<>();

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
        this.service = service;
    }

    /**
     * Logout. Clears SharedPreferences and switches view to LoginActivity.
     */
    public void logout(){

        // logout the user
        LoginService.logout(activity.getApplicationContext());

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
        service.getPosts().enqueue(new Callback<List<Post>>() {

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                // assign response objects to list
                posts = response.body();

                // send posts to activity
                activity.setUpList(posts);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

    /**
     * Returns list of posts.
     * @return
     */
    public List<Post> getPosts(){
        return posts;
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
