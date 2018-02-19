package tomaszkopacz.meetbam.di.components;

import javax.inject.Singleton;

import dagger.Component;
import tomaszkopacz.meetbam.activities.AccountActivity;
import tomaszkopacz.meetbam.activities.StatsActivity;
import tomaszkopacz.meetbam.di.providers.FragmentModule;

/**
 * Created by tomas on 19.02.2018.
 */

@Singleton
@Component(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(AccountActivity mAccountActivity);
    void inject(StatsActivity mStatsActivity);
}
