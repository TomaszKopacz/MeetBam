package tomaszkopacz.meetbam.presenters;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.activities.LoginActivity;
import tomaszkopacz.meetbam.activities.MainActivity;
import tomaszkopacz.meetbam.dialogs.AcceptPhotoDialog;
import tomaszkopacz.meetbam.dialogs.ChooseDeviceDialog;
import tomaszkopacz.meetbam.model.Post;
import tomaszkopacz.meetbam.model.User;
import tomaszkopacz.meetbam.service.CameraService;
import tomaszkopacz.meetbam.service.LoginService;
import tomaszkopacz.meetbam.service.PostAdapter;
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

    //bt pairing
    private AcceptPhotoDialog acceptPhotoDialog;
    private ChooseDeviceDialog chooseDeviceDialog;
    private BluetoothAdapter bluetoothAdapter;
    private IntentFilter btDetectionIntentFilter;
    private List<BluetoothDevice> discoveredDevices = new ArrayList<>();

    //current post
    private Uri photoUri;
    private User pairedUser;

    public MainActivityPresenter(MainActivity activity, WebService service){
        this.activity = activity;
        this.mWebService = service;
        this.mLoginService = new LoginService(activity.getApplicationContext());

        setUpAdapter();
        setUpBluetoothIntentFilters();
    }

    public void downloadPostsListToActivity(){
        posts.clear();

        Call call = mWebService.getFriendsPosts(mLoginService.getUserMail());
        call.enqueue(new Callback<List<Post>>() {

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                posts = response.body();
                activity.putPosts(adapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

    public void photoAttempt(){
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled())
            requestBT();
        else {
            activity.registerReceiver(btDetectionReceiver, btDetectionIntentFilter);
            makePhoto();
        }
    }

    public void afterPhotoTaken(){
        if (photoUri != null) {
            acceptPhotoDialog = new AcceptPhotoDialog(activity, this);
            acceptPhotoDialog.loadPhoto(photoUri);
            acceptPhotoDialog.show();
        }
    }

    public void pair(){
        discoveredDevices.clear();

        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled())
            Toast.makeText(activity, "Bluetooth not enabled!", Toast.LENGTH_LONG).show();
        else
            scanDevices();
    }

    public void deviceSelected(String device){
        Call<List<User>> call = mWebService.getUserLoggedOnDevice(device);
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if (response.body().size() != 0){

                    acceptPhotoDialog.getProgressBar().setVisibility(View.GONE);

                    pairedUser = response.body().get(0);
                    String name = pairedUser.getName();
                    String surname = pairedUser.getSurname();
                    acceptPhotoDialog.getPersonTextView().setText(name + " " + surname);

                    acceptPhotoDialog.getAcceptBtn().setClickable(true);
                    acceptPhotoDialog.getAcceptBtn().setTextColor(Color.BLACK);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
            }
        });

        chooseDeviceDialog.dismiss();
    }

    public void uploadPhoto(){
        acceptPhotoDialog.dismiss();

        File photo = new File(photoUri.getPath());
        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), photo);
        MultipartBody.Part file =
                MultipartBody.Part.createFormData("file", photo.getName(), requestBody);
        RequestBody user1
                = RequestBody.create(MediaType.parse("text/plain"), LoginService.getUserMail());
        RequestBody user2
                = RequestBody.create(MediaType.parse("text/plain"), pairedUser.getMail());

        Call<ResponseBody> call = mWebService.uploadPost(file, user1, user2);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Snackbar.make(activity.findViewById(R.id.coordinator),
                            "Photo uploaded successfully!", Snackbar.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Snackbar.make(activity.findViewById(R.id.coordinator),
                        "Ups! Error while uploading photo!", Snackbar.LENGTH_LONG).show();
            }
        });

        photoUri = null;
        pairedUser = null;
    }

    public void logout(){
        mLoginService.logout();

        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    public void onItemBoundAtPosition(RecyclerView.ViewHolder holder, int position) {
        Post post = posts.get(position);
        ((PostViewHolder)holder).setContent(post, activity, BASE_URL);
    }

    @Override
    public void onItemClick(View view) {
        //int position = activity.getPostsRecView().getChildAdapterPosition(view);
        //posts.remove(position);
        //adapter.notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    private void setUpAdapter(){
        this.adapter = new PostAdapter(this);
    }

    private void setUpBluetoothIntentFilters(){
        btDetectionIntentFilter = new IntentFilter();
        btDetectionIntentFilter.addAction(BluetoothDevice.ACTION_FOUND);
    }

    private Uri getCustomPhotoUri(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSSS");
        String photoFileName = dateFormat.format(new Date()) + ".jpg";
        File photoFile = CameraService.getFileForDirectory(PHOTO_DIRECTORY, photoFileName);
        return Uri.fromFile(photoFile);
    }

    private void requestBT(){
        if (bluetoothAdapter == null)
            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (!bluetoothAdapter.isEnabled()) {
            Snackbar btRequestSnackBar = Snackbar
                    .make(activity.findViewById(R.id.coordinator), "Bluetooth turned off", Snackbar.LENGTH_LONG)
                    .setAction("OPEN", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bluetoothAdapter.enable();
                            activity.registerReceiver(btDetectionReceiver, btDetectionIntentFilter);
                        }
                    });
            btRequestSnackBar.show();
        }
    }

    private void makePhoto(){
        photoUri = getCustomPhotoUri();
        File img = new File(photoUri.getPath());

        if (img != null){
            Intent cameraIntent = CameraService.getCameraIntent(img);
            activity.startActivityForResult(cameraIntent, activity.CAMERA_CODE);
        }
    }

    private void scanDevices(){
        if (acceptPhotoDialog != null)
            acceptPhotoDialog.getProgressBar().setVisibility(View.VISIBLE);

        chooseDeviceDialog = new ChooseDeviceDialog(activity, this);
        afterDiscoveryHandler.postDelayed(afterDiscoveryRunnable, 5000);
        bluetoothAdapter.startDiscovery();
    }

    private BroadcastReceiver btDetectionReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            switch (action){
                case BluetoothDevice.ACTION_FOUND:
                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    discoveredDevices.add(device);
                    break;
            }
        }
    };

    private Handler afterDiscoveryHandler = new Handler();
    private Runnable afterDiscoveryRunnable = new Runnable() {
        @Override
        public void run() {
            bluetoothAdapter.cancelDiscovery();
            activity.unregisterReceiver(btDetectionReceiver);

            chooseDeviceDialog.setDevices(discoveredDevices);
            chooseDeviceDialog.show();
        }
    };
}
