package tomaszkopacz.meetbam.di.providers;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import tomaszkopacz.meetbam.activities.AccountFriendsFragment;
import tomaszkopacz.meetbam.activities.AccountInfoFragment;
import tomaszkopacz.meetbam.activities.AccountPhotosFragment;
import tomaszkopacz.meetbam.activities.StatsGlobalFragment;
import tomaszkopacz.meetbam.activities.StatsLocalFragment;

/**
 * Created by tomas on 19.02.2018.
 * Module providing fragments instances.
 */

@Module
public class FragmentModule {

    @Provides
    @Singleton
    static AccountInfoFragment getAccountInfoFragment(){
        return new AccountInfoFragment();
    }

    @Provides
    @Singleton
    static AccountPhotosFragment getAccountPhotosFragment(){
        return new AccountPhotosFragment();
    }

    @Provides
    @Singleton
    static AccountFriendsFragment getAccountFriendsFragment(){
        return new AccountFriendsFragment();
    }

    @Provides
    @Singleton
    static StatsLocalFragment getStatsLocalFragment(){
        return new StatsLocalFragment();
    }

    @Provides
    @Singleton
    static StatsGlobalFragment getStatsGlobalFragment(){
        return new StatsGlobalFragment();
    }
}
