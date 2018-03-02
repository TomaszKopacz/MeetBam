package tomaszkopacz.meetbam.presenters;

import javax.inject.Inject;

import tomaszkopacz.meetbam.activities.StatsGlobalFragment;

/**
 * Created by tomas on 02.03.2018.
 */

public class StatsGlobalFragmentPresenter {

    private StatsGlobalFragment fragment;

    /**
     * Constructor.
     */
    @Inject
    public StatsGlobalFragmentPresenter(){

    }

    /**
     * Sets fragment.
     * @param fragment
     */
    public void setFragment(StatsGlobalFragment fragment) {
        this.fragment = fragment;
    }
}
