package tomaszkopacz.meetbam.tabs_service;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        ((PostViewHolder) holder).name.setText(post.getName());
        ((PostViewHolder) holder).surname.setText(post.getSurname());
        ((PostViewHolder) holder).time.setText(post.getTime());

        // download and set image
        Glide
                .with(activity)
                .load(BASE_URL + post.getPhotoDir())
                .into(((PostViewHolder) holder).photo);

        // count time since post was uploaded:
        // original timestamp from server is "yyyy-MM-dd hh:mm:ss.xxxxxx", need to be
        // converted to "yyyy-MM-dd hh:mm:ss" pattern, so it can be used in
        // countTimeAgo(String timestamp) method
        String timestamp = post.getTime().substring(0, 19);
        long timeAgo = countTimeAgo(timestamp);

        // get appropriate info about how long ago post was uploaded
        String timeAgoText = getTimeAgoText(timeAgo);
        ((PostViewHolder) holder).time.setText(timeAgoText);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    /**
     * Counts time interval between now and given timestamp. The timestamp
     * should be given in "yyyy-MM-dd hh:mm:ss" pattern. The result is time in minutes.
     * @param timestamp
     * @return time interval started from timestamp and ending now. If error occurs, returns -1.
     */
    private long countTimeAgo(String timestamp){

        // date pattern
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        // time interval
        long diff;

        try {
            // convert timestamp to given pattern
            Date timestampDate = simpleDateFormat.parse(timestamp);

            // get actual date and convert to pattern
            Date date = new Date();
            simpleDateFormat.format(date);

            // count difference in millis
            diff = date.getTime() - timestampDate.getTime();

            // convert millis to minutes
            diff = diff/(1000*60);

        } catch (ParseException e) {
            return -1;
        }

        return diff;
    }

    /**
     * Returns text according to a given time. If time is less than 1h, returns
     * result in minutes. If time is less than a day, returns result in hours. Otherwise,
     * returns result in days. If given time is less than zero, returns "TIME ERROR" message.
     * @param timeAgo time given in minutes
     * @return text about haw many time went off
     */
    private String getTimeAgoText(long timeAgo){

        if (timeAgo < 0)
            return "TIME ERROR";
        else if (timeAgo == 1)
            return "1" + " minute ago";
        else if (timeAgo < 60)
            return String.valueOf(timeAgo) + " minutes ago";
        else if (timeAgo < 120)
            return "1" + " hour ago";
        else if (Math.round(timeAgo) < 1440)
            return String.valueOf(timeAgo/60) + " hours ago";
        else if (timeAgo < 2880)
            return "1" + " day ago";
        else
            return String.valueOf(Math.round(timeAgo/(60*24))) + " days ago";
    }
}
