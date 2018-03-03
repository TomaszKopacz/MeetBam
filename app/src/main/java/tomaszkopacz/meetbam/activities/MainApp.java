package tomaszkopacz.meetbam.activities;

import android.app.Application;

import tomaszkopacz.meetbam.di.components.DaggerFragmentComponent;
import tomaszkopacz.meetbam.di.components.DaggerWebServiceComponent;
import tomaszkopacz.meetbam.di.components.FragmentComponent;
import tomaszkopacz.meetbam.di.components.WebServiceComponent;

/**
 * Created by tomas on 19.02.2018.
 */

public class MainApp extends Application {

    private FragmentComponent mFragmentComponent;
    private WebServiceComponent mWebServiceComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mFragmentComponent = DaggerFragmentComponent.builder().build();
        mWebServiceComponent = DaggerWebServiceComponent.builder().build();
    }

    /**
     * Returns fragment component.
     * @return
     */
    public FragmentComponent getFragmentComponent(){
        return mFragmentComponent;
    }

    /**
     * Returns web service component.
     * @return
     */
    public WebServiceComponent getWebServiceComponent(){
        return mWebServiceComponent;
    }
}
