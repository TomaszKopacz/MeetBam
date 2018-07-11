package tomaszkopacz.meetbam.view

import android.app.Application
import tomaszkopacz.meetbam.di.DaggerWebServiceComponent
import tomaszkopacz.meetbam.di.WebServiceComponent
import tomaszkopacz.meetbam.service.TypefaceUtil

class MainApp : Application() {

    var webServiceComponent: WebServiceComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        webServiceComponent = DaggerWebServiceComponent.builder().build()
        TypefaceUtil.overrideFont(
                this,
                "SERIF",
                "Comfortaa_Regular.ttf")
    }
}
