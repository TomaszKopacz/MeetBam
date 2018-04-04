package tomaszkopacz.meetbam.di.components;

import javax.inject.Singleton;

import dagger.Component;
import tomaszkopacz.meetbam.activities.LoginActivity;
import tomaszkopacz.meetbam.activities.MainActivity;
import tomaszkopacz.meetbam.di.providers.WebServiceModule;

/**
 * Created by tomas on 03.03.2018.
 */

@Singleton
@Component(modules = WebServiceModule.class)
public interface WebServiceComponent {

    void inject(MainActivity mMainActivity);
    void inject(LoginActivity mLoginActivity);
}
