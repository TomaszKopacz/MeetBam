package tomaszkopacz.meetbam.tabs_service;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tomaszkopacz.meetbam.R;

/**
 * Class holding view of each object.
 */
public class PostViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.post_id)
    TextView id;

    @BindView(R.id.post_mail)
    TextView mail;

    @BindView(R.id.post_photodir)
    TextView photoDir;

    @BindView(R.id.post_time)
    TextView time;

    public PostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
