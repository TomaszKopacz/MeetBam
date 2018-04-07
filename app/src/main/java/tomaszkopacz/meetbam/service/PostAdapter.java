package tomaszkopacz.meetbam.service;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.activities.MainActivity;
import tomaszkopacz.meetbam.model.Post;

/**
 * Created by tomas on 03.03.2018.
 * Creates dynamic recycler view list of posts.
 */

public class PostAdapter extends RecyclerView.Adapter {

    // activity context
    private MainActivity activity;

    // data source
    private List<Post> posts = new ArrayList<>();

    // list
    private RecyclerView recyclerView;

    // photo base url
    private static final String BASE_URL = "http://meetbam.cba.pl/";

    /**
     * Constructor.
     */
    public PostAdapter(MainActivity activity, List<Post> posts, RecyclerView recyclerView){
        this.activity = activity;
        this.posts = posts;
        this.recyclerView = recyclerView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);

        // remove item when clicked
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = recyclerView.getChildAdapterPosition(view);
                posts.remove(position);
                notifyItemRemoved(position);
            }
        });

        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Post post = posts.get(position);

        //set text views
        ((PostViewHolder) holder).name1.setText(post.getName1() + " " + post.getSurname1());
        ((PostViewHolder) holder).name2.setText(post.getName2() + " " + post.getSurname2());
        ((PostViewHolder) holder).time.setText(post.getTime());

        // download and set image
        Glide
                .with(activity)
                .load(BASE_URL + post.getPhotoDir())
                .into(((PostViewHolder) holder).photo);

        // count time since post was uploaded
        float timeAgo = PostTimeProvider.countTimeAgo(post.getTime());

        // get appropriate info about how long ago post was uploaded
        String timeAgoText = PostTimeProvider.getTimeAgoText(timeAgo);
        ((PostViewHolder) holder).time.setText(timeAgoText);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
