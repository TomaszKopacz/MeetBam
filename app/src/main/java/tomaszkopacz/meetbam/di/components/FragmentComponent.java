package tomaszkopacz.meetbam.di.components;

import javax.inject.Singleton;

import dagger.Component;
import tomaszkopacz.meetbam.activities.AccountActivity;
import tomaszkopacz.meetbam.activities.AccountFriendsFragment;
import tomaszkopacz.meetbam.activities.AccountInfoFragment;
import tomaszkopacz.meetbam.activities.AccountPhotosFragment;
import tomaszkopacz.meetbam.activities.MainActivity;
import tomaszkopacz.meetbam.activities.StatsActivity;
import tomaszkopacz.meetbam.activities.StatsGlobalFragment;
import tomaszkopacz.meetbam.activities.StatsLocalFragment;
import tomaszkopacz.meetbam.di.providers.WebServiceModule;
import tomaszkopacz.meetbam.presenters.AccountFriendsFragmentPresenter;
import tomaszkopacz.meetbam.presenters.AccountInfoFragmentPresenter;
import tomaszkopacz.meetbam.presenters.AccountPhotosFragmentPresenter;
import tomaszkopacz.meetbam.presenters.MainActivityPresenter;
import tomaszkopacz.meetbam.presenters.StatsGlobalFragmentPresenter;
import tomaszkopacz.meetbam.presenters.StatsLocalFragmentPresenter;

/**
 * Created by tomas on 19.02.2018.
 */

@Singleton
@Component (modules = WebServiceModule.class)
public interface FragmentComponent {

    AccountFriendsFragment mAccountFriendsFragment();
    AccountInfoFragment mAccountInfoFragment();
    AccountPhotosFragment mAccountPhotosFragment();
    StatsGlobalFragment mStatsGlobalFragment();
    StatsLocalFragment mStatsLocalFragment();

    AccountInfoFragmentPresenter mAccountInfoFragmentPresenter();
    AccountPhotosFragmentPresenter mAccountPhotosFragmentPresenter();
    AccountFriendsFragmentPresenter mAccountFriendsFragmentPresenter();
    StatsLocalFragmentPresenter mStatsLocalFragmentPresenter();
    StatsGlobalFragmentPresenter mStatsGlobalFragmentPresenter();

    void inject(AccountActivity mAccountActivity);
    void inject(StatsActivity mStatsActivity);

    void inject(AccountInfoFragment mAccountInfoFragment);
    void inject(AccountPhotosFragment mAccountPhotosFragment);
    void inject(AccountFriendsFragment mAccountFriendsFragment);
    void inject(StatsLocalFragment mStatsLocalFragment);
    void inject(StatsGlobalFragment mStatsGlobalFragment);
}
