package tomaszkopacz.meetbam.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.presenters.MainActivityPresenter;
/**
 * Created by tomas on 09.03.2018.
 */

public class AcceptPhotoDialog extends Dialog{

    MainActivityPresenter presenter;

    @BindView(R.id.photo)
    ImageView photoImageView;

    @BindView(R.id.person_found)
    TextView personTextView;

    @BindView(R.id.circular_progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.pair_btn)
    Button searchBtn;

    @BindView(R.id.accept_btn)
    Button acceptBtn;

    public AcceptPhotoDialog(Context context, MainActivityPresenter presenter) {
        super(context);
        setContentView(R.layout.dialog_accept_photo);
        ButterKnife.bind(this);
        this.presenter = presenter;
    }

    @OnClick(R.id.pair_btn)
    public void onPairBtnClick(){
        presenter.pair();
    }

    @OnClick(R.id.accept_btn)
    public void onAcceptBtnClick(){
        presenter.uploadPhoto();
    }

    public void loadPhoto(Uri uri){
        if (uri != null)
            Glide.with(getContext()).load(uri).into(photoImageView);
    }

    public ImageView getPhotoImageView() {
        return photoImageView;
    }

    public TextView getPersonTextView() {
        return personTextView;
    }

    public ProgressBar getProgressBar(){
        return progressBar;
    }

    public Button getSearchBtn() {
        return searchBtn;
    }

    public Button getAcceptBtn() {
        return acceptBtn;
    }
}
