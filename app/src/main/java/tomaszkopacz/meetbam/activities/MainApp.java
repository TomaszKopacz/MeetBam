package tomaszkopacz.meetbam.activities;

import android.app.Application;

import tomaszkopacz.meetbam.di.components.DaggerWebServiceComponent;
import tomaszkopacz.meetbam.di.components.WebServiceComponent;

/**
 * Created by tomas on 19.02.2018.
 */

public class MainApp extends Application {

    private WebServiceComponent mWebServiceComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mWebServiceComponent = DaggerWebServiceComponent.builder().build();
    }

    /**
     * Returns web service component.
     * @return
     */
    public WebServiceComponent getWebServiceComponent(){
        return mWebServiceComponent;
    }
}
