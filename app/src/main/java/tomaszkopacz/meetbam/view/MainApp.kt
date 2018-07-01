package tomaszkopacz.meetbam.view

import android.app.Application
import tomaszkopacz.meetbam.di.DaggerWebServiceComponent
import tomaszkopacz.meetbam.di.WebServiceComponent

class MainApp : Application() {

    var webServiceComponent: WebServiceComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        webServiceComponent = DaggerWebServiceComponent.builder().build()
    }
}
