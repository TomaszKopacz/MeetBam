package tomaszkopacz.meetbam.service;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import tomaszkopacz.meetbam.R;

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
