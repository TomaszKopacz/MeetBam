package tomaszkopacz.meetbam.presenters;

import android.util.Log;

import javax.inject.Inject;

import tomaszkopacz.meetbam.activities.AccountFriendsFragment;

/**
 * Created by tomas on 02.03.2018.
 */

public class AccountFriendsFragmentPresenter {

    private AccountFriendsFragment fragment;

    /**
     * Constructor.
     */
    @Inject
    public AccountFriendsFragmentPresenter (){
    }

    /**
     * Sets fragment.
     * @param fragment
     */
    public void setFragment(AccountFriendsFragment fragment) {
        this.fragment = fragment;
    }

    public void btnClicked() {
        Log.d("TomaszKopacz", "OnClick - presenter");
        fragment.changeText("DUUUPA");
    }
}
