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
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
    private Uri photoUri;

    //bt pairing
    private AcceptPhotoDialog acceptPhotoDialog;
    private ChooseDeviceDialog chooseDeviceDialog;
    private BluetoothAdapter bluetoothAdapter;
    private IntentFilter btDetectionIntentFilter;
    private List<BluetoothDevice> discoveredDevices = new ArrayList<>();

    public MainActivityPresenter(MainActivity activity, WebService service){
        this.activity = activity;
        this.mWebService = service;
        this.mLoginService = new LoginService(activity.getApplicationContext());

        setUpAdapter();
        setUpIntentFilters();
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

    public void makePhoto(){
        String photoFileName = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                .format(new Date()) + ".jpg";
        File photoFile = CameraService.getFileForDirectory(PHOTO_DIRECTORY, photoFileName);
        photoUri = Uri.fromFile(photoFile);

        if (photoFile != null){
            Intent cameraIntent = CameraService.getCameraIntent(photoFile);
            activity.startActivityForResult(cameraIntent, activity.CAMERA_CODE);
        }
    }

    public void afterPhotoTaken(){
        acceptPhotoDialog = new AcceptPhotoDialog(activity, this);
        acceptPhotoDialog.loadPhoto(photoUri);
        acceptPhotoDialog.show();
    }

    public void addPhoto(){
        Toast.makeText(activity, "PHOTO UPLOADED!", Toast.LENGTH_SHORT).show();
        acceptPhotoDialog.dismiss();
    }

    public void pair(){

        discoveredDevices.clear();
        requestBT();
        activity.registerReceiver(btDetectionReceiver, btDetectionIntentFilter);

        chooseDeviceDialog = new ChooseDeviceDialog(activity, this);

        afterDiscoveryHandler.postDelayed(afterDiscoveryRunnable, 5000);
        bluetoothAdapter.startDiscovery();
    }

    public void deviceSelected(String device){
        Call<List<User>> call = mWebService.getUserLoggedOnDevice(device);
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if (response.body().size() != 0){
                    User user = response.body().get(0);
                    String name = user.getName();
                    String surname = user.getSurname();
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
        int position = activity.getPostsRecView().getChildAdapterPosition(view);
        // posts.remove(position);
        // adapter.notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    private void setUpAdapter(){
        this.adapter = new PostAdapter(this);
    }

    private void setUpIntentFilters(){
        btDetectionIntentFilter = new IntentFilter();
        btDetectionIntentFilter.addAction(BluetoothDevice.ACTION_FOUND);
    }

    private void requestBT(){
        if (bluetoothAdapter == null)
            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent =
                    new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            activity.startActivityForResult(enableBtIntent, 0);
        }
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
