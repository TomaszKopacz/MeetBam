package tomaszkopacz.meetbam.service;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.model.Post;

/**
 * Class holding view of each object.
 */
public class PostViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.name1)
    TextView name1;

    @BindView(R.id.name2)
    TextView name2;

    @BindView(R.id.post_photo)
    ImageView photo;

    @BindView(R.id.post_time)
    TextView time;

    public PostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setContent(Post post, Activity activity, String photoUrl){

        getName1().setText(post.getName1() + " " + post.getSurname1());
        getName2().setText(post.getName2() + " " + post.getSurname2());

        Glide
                .with(activity)
                .load(photoUrl + post.getPhotoDir())
                .into(getPhoto());

        float timeAgo = PostTimeProvider.countTimeAgo(post.getTime());
        String timeAgoText = PostTimeProvider.getTimeAgoText(timeAgo);
        getTime().setText(timeAgoText);
    }

    public TextView getName1() {
        return name1;
    }

    public void setName1(TextView name1) {
        this.name1 = name1;
    }

    public TextView getName2() {
        return name2;
    }

    public void setName2(TextView name2) {
        this.name2 = name2;
    }

    public ImageView getPhoto() {
        return photo;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }

    public TextView getTime() {
        return time;
    }

    public void setTime(TextView time) {
        this.time = time;
    }
}
