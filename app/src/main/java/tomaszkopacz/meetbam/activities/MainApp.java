package tomaszkopacz.meetbam.activities;

import android.app.Application;

import tomaszkopacz.meetbam.di.components.DaggerFragmentComponent;
import tomaszkopacz.meetbam.di.components.FragmentComponent;

/**
 * Created by tomas on 19.02.2018.
 */

public class MainApp extends Application {

    private FragmentComponent mFragmentComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mFragmentComponent = DaggerFragmentComponent.builder().build();
    }

    /**
     * Returns fragment component.
     * @return
     */
    public FragmentComponent getFragmentComponent(){
        return mFragmentComponent;
    }
}
