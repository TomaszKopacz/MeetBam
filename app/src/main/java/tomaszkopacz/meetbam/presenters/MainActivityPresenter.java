package tomaszkopacz.meetbam.presenters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tomaszkopacz.meetbam.activities.MainActivity;
import tomaszkopacz.meetbam.model.Post;
import tomaszkopacz.meetbam.web_service.WebService;

/**
 * Created by tomas on 03.03.2018.
 */

public class MainActivityPresenter {

    private MainActivity activity;
    private WebService service;

    private List<Post> posts = new ArrayList<>();

    /**
     * Constructor.
     */
    public MainActivityPresenter(MainActivity activity, WebService service){
        this.activity = activity;
        this.service = service;
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
     * Returns list of
     * @return
     */
    public List<Post> getPosts(){
        return posts;
    }

}
