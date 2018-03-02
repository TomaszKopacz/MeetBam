package tomaszkopacz.meetbam.presenters;

import javax.inject.Inject;

import tomaszkopacz.meetbam.activities.AccountInfoFragment;

/**
 * Created by tomas on 02.03.2018.
 */

public class AccountInfoFragmentPresenter {

    private AccountInfoFragment fragment;

    /**
     * Constructor.
     */
    @Inject
    public AccountInfoFragmentPresenter(){

    }

    /**
     * Sets fragment.
     * @param fragment
     */
    public void setFragment(AccountInfoFragment fragment) {
        this.fragment = fragment;
    }
}
