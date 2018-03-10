package tomaszkopacz.meetbam.presenters;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

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
import tomaszkopacz.meetbam.activities.MainActivity;
import tomaszkopacz.meetbam.model.Post;
import tomaszkopacz.meetbam.web_service.WebService;

/**
 * Created by tomas on 03.03.2018.
 */

public class MainActivityPresenter implements Presenter{

    private MainActivity activity;
    private WebService service;

    private List<Post> posts = new ArrayList<>();

    // photo storage directory
    private static final String PHOTO_DIRECTORY
            = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES) + "/Meetbam/";

    private AcceptPhotoDialog dialog;

    /**
     * Constructor.
     */
    public MainActivityPresenter(MainActivity activity, WebService service){
        this.activity = activity;
        this.service = service;

        //prepare directory to store photos
        preparePhotosDirectory();
    }

    /**
     * Sets the directory and creates file for photos taken by user.
     */
    private void preparePhotosDirectory(){
        File photosFile = new File(PHOTO_DIRECTORY);
        photosFile.mkdirs();
    }

    /**
     * Downloads posts and send them to activity.
     */
    public void createPostsList(){
        //get new elements
        posts.clear();

        service.getPosts().enqueue(new Callback<List<Post>>() {

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                //assign response objects to list
                posts = response.body();

                //send posts to activity
                activity.setUpList(posts);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

    /**
     * Starts camera. Creates file for available photo.
     */
    public void makePhoto(){

        // create file to store photo
        File photoFile = getPhotoFile();

        // open camera activity
        if (photoFile != null){
            Intent cameraIntent = getCameraIntent(photoFile);
            activity.startActivityForResult(cameraIntent, activity.CAMERA_CODE);
        }
    }

    /**
     * Show dialog (to accept picture and pair with new person).
     */
    public void showAcceptPhotoDialog(){
        dialog = new AcceptPhotoDialog(activity, this);
        dialog.show();
    }

    /**
     * Pair with a new person.
     */
    public void pair(){
        dialog.getPersonTextView().setText("ZBYSZEK");
    }

    /**
     * Return new photo file in default pictures directory. File name is 'currenttimestamp.jpg'.
     * @return photo file
     */
    private File getPhotoFile(){

        // photo name
        String photoName
                = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + ".jpg";

        // photo directory
        String photoDir = PHOTO_DIRECTORY + photoName;

        // photo file
        File photoFile = new File(photoDir);

        try {
            photoFile.createNewFile();

        } catch (IOException e) {

        }

        return photoFile;
    }

    /**
     * Returns camera intent, that stores photos in photoFile uri.
     * @param photoFile file to store photos
     * @return intent
     */
    private Intent getCameraIntent(File photoFile){

        // get photo uri
        Uri photoUri = Uri.fromFile(photoFile);

        // create intent
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);

        return cameraIntent;
    }

    /**
     * Returns list of posts.
     * @return
     */
    public List<Post> getPosts(){
        return posts;
    }

}
