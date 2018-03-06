package tomaszkopacz.meetbam.tabs_service;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.model.Post;

/**
 * Created by tomas on 03.03.2018.
 * Creates dynamic recycler view list of posts.
 */

public class PostAdapter extends RecyclerView.Adapter {

    //data source
    private List<Post> posts = new ArrayList<>();

    //list
    private RecyclerView recyclerView;

    /**
     * Constructor.
     */
    public PostAdapter(List<Post> posts, RecyclerView recyclerView){
        this.posts = posts;
        this.recyclerView = recyclerView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);

        //remove item when clicked
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
        ((PostViewHolder)holder).id.setText(post.getId());
        ((PostViewHolder)holder).mail.setText(post.getMail());
        ((PostViewHolder)holder).photoDir.setText(post.getPhotoDir());
        ((PostViewHolder)holder).time.setText(post.getTime());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
