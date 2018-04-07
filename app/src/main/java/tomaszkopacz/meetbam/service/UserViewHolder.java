package tomaszkopacz.meetbam.service;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tomaszkopacz.meetbam.R;

/**
 * Created by tomas on 07.04.2018.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.username)
    TextView username;

    @BindView(R.id.user_image)
    ImageView userImage;

    public UserViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
