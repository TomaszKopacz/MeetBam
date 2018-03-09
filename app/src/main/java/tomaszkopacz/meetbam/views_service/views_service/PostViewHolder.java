package tomaszkopacz.meetbam.views_service.views_service;

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

    @BindView(R.id.post_name)
    TextView name;

    @BindView(R.id.post_surname)
    TextView surname;

    @BindView(R.id.post_photo)
    ImageView photo;

    @BindView(R.id.post_time)
    TextView time;

    public PostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
