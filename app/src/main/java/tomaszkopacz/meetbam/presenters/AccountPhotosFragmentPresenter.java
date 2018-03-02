package tomaszkopacz.meetbam.presenters;

import javax.inject.Inject;

import tomaszkopacz.meetbam.activities.AccountPhotosFragment;

/**
 * Created by tomas on 02.03.2018.
 */

public class AccountPhotosFragmentPresenter {

    private AccountPhotosFragment fragment;

    /**
     * Constructor.
     */
    @Inject
    public AccountPhotosFragmentPresenter(){

    }

    /**
     * Sets fragment.
     * @param fragment
     */
    public void setFragment(AccountPhotosFragment fragment) {
        this.fragment = fragment;
    }
}
