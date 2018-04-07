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
    public AccountInfoFragmentPresenter(AccountInfoFragment fragment){

        this.fragment = fragment;
    }
}
