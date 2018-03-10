package tomaszkopacz.meetbam.activities;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

    @BindView(R.id.pair_btn)
    Button pairBtn;

    public AcceptPhotoDialog(Context context, MainActivityPresenter presenter) {
        super(context);

        // set layout
        setContentView(R.layout.dialog_accept_photo);

        // bind views
        ButterKnife.bind(this);

        // set presenter
        this.presenter = presenter;
    }

    @OnClick(R.id.pair_btn)
    public void onPairBtnClick(){
        presenter.pair();
    }

    public ImageView getPhotoImageView() {
        return photoImageView;
    }

    public TextView getPersonTextView() {
        return personTextView;
    }

    public Button getPairBtn() {
        return pairBtn;
    }
}
