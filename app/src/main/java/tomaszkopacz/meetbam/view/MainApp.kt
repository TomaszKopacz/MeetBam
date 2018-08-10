package tomaszkopacz.meetbam.view

import android.app.Application
import tomaszkopacz.meetbam.di.AppComponent
import tomaszkopacz.meetbam.di.DaggerAppComponent
import tomaszkopacz.meetbam.entity.User
import tomaszkopacz.meetbam.service.Preferences
import tomaszkopacz.meetbam.service.TypefaceUtil

class MainApp : Application() {

    var component: AppComponent? = null
        private set

    private var prefs: Preferences? = null

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder().build()

        TypefaceUtil.overrideFont(
                this,
                "SERIF",
                "Comfortaa_Regular.ttf")

        prefs = Preferences(this)
    }

    fun login(mail: String, name: String, surname: String, password: String) {

        prefs!!.name = name
        prefs!!.surname = surname
        prefs!!.mail = mail
        prefs!!.password = password
    }

    fun logout() {
        prefs!!.removeAll()
    }

    fun isUserLoggedIn(): Boolean {
        return (prefs!!.name != prefs!!.NO_USER && prefs!!.surname != prefs!!.NO_USER &&
                prefs!!.mail != prefs!!.NO_USER && prefs!!.password != prefs!!.NO_USER)
    }

    fun getLoggedUser(): User {
        val user = User()

        if (isUserLoggedIn()) {
            user.name = prefs!!.name
            user.surname = prefs!!.surname
            user.mail = prefs!!.mail
            user.password = prefs!!.password
        }

        return user
    }
}
