package tomaszkopacz.meetbam.presenters;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tomaszkopacz.meetbam.activities.MainActivity;
import tomaszkopacz.meetbam.model.Post;
import tomaszkopacz.meetbam.web_service.WebService;

/**
 * Created by tomas on 03.03.2018.
 */

public class MainActivityPresenter {

    private MainActivity activity;
    private Retrofit retrofit;
    private WebService service;

    private List<Post> posts = new ArrayList<>();

    private static final String TAG = "MEETBAM";
    private static final String TAG_FAIL = "FAIL";
    private static final String BASE_URL = "http://meetbam.cba.pl";

    /**
     * Constructor.
     */
    @Inject
    public MainActivityPresenter (){

    }

    /**
     * Sets activity.
     * @param activity
     */
    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }

    /**
     * Sets up web components.
     */
    public void setUpWebService(){

        OkHttpClient.Builder client = new OkHttpClient.Builder();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(WebService.class);
    }

    /**
     * Downloads posts and asks the activity to create list of them.
     */
    public void getPostsList(){

        //remove previous elements
        posts.clear();

        //get new elements
        Call<List<Post>> call = service.getData();
        call.enqueue(new Callback<List<Post>>() {

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                //assign response objects to list
                posts = response.body();

                //send list objects to the list of activity
                activity.setUpList(posts);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d(TAG, TAG_FAIL);
            }
        });
    }
}
