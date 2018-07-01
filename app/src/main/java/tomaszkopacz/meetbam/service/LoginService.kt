package tomaszkopacz.meetbam.service

import android.content.Context
import tomaszkopacz.meetbam.entity.User

class LoginService(context: Context) {

    private var prefs: Preferences = Preferences(context)

    fun login(mail: String, name: String, surname: String, password: String) {

        prefs.name = name
        prefs.surname = surname
        prefs.mail = mail
        prefs.password = password
    }

    fun logout() {
        prefs.removeAll()
    }

    fun isUserLoggedIn(): Boolean {
        return (prefs.name != prefs.NO_USER && prefs.surname != prefs.NO_USER &&
                prefs.mail != prefs.NO_USER && prefs.password != prefs.NO_USER)
    }

    fun getLoggedUser(): User{
        var user = User()

        if (isUserLoggedIn()) {
            user.name = prefs.name
            user.surname = prefs.surname
            user.mail = prefs.mail
            user.password = prefs.password
        }

        return user
    }
}
