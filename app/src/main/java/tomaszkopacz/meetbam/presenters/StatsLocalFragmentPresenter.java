package tomaszkopacz.meetbam.presenters;

import android.app.Fragment;

import javax.inject.Inject;

import tomaszkopacz.meetbam.activities.AccountFriendsFragment;
import tomaszkopacz.meetbam.activities.StatsLocalFragment;

/**
 * Created by tomas on 02.03.2018.
 */

public class StatsLocalFragmentPresenter {

    private StatsLocalFragment fragment;

    /**
     * Constructor.
     */
    @Inject
    public StatsLocalFragmentPresenter(){

    }

    /**
     * Sets fragment.
     * @param fragment
     */
    public void setFragment(StatsLocalFragment fragment) {
        this.fragment = fragment;
    }
}
