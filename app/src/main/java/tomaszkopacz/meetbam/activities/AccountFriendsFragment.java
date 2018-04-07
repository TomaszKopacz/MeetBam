package tomaszkopacz.meetbam.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.presenters.AccountFriendsFragmentPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFriendsFragment extends Fragment {

    private AccountFriendsFragmentPresenter presenter;

    @BindView(R.id.friendsText)
    TextView friendsText;

    @BindView(R.id.friendsBtn)
    Button friendsBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account_friends, container, false);

        //bind view
        ButterKnife.bind(this, view);

        //set up presenter
        presenter = new AccountFriendsFragmentPresenter(this);

        return view;
    }

    @OnClick(R.id.friendsBtn)
    public void btnClicked(){
        Log.d("TomaszKopacz", "OnClick");
        presenter.btnClicked();
    }

    public void changeText(String text){
        Log.d("TomaszKopacz", "ChangeText");
        friendsText.setText(text);
    }
}
