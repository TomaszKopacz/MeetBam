package tomaszkopacz.meetbam.service

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class Preferences(context: Context) {

    val NAME: String = "NAME"
    val SURNAME: String = "SURNAME"
    val MAIL: String = "MAIL"
    val PASSWORD: String = "PASSWORD"
    val NO_USER: String = "NO_USER"
    val PREFS: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    var name: String
        get() = PREFS.getString(NAME, NO_USER)
        set(value) = PREFS.edit().putString(NAME, value).apply()

    var surname: String
        get() = PREFS.getString(SURNAME, NO_USER)
        set(value) = PREFS.edit().putString(SURNAME, value).apply()

    var mail: String
        get() = PREFS.getString(MAIL, NO_USER)
        set(value) = PREFS.edit().putString(MAIL, value).apply()

    var password: String
        get() = PREFS.getString(PASSWORD, NO_USER)
        set(value) = PREFS.edit().putString(PASSWORD, value).apply()

    fun removeAll(){
        PREFS.edit().remove(NAME).apply()
        PREFS.edit().remove(SURNAME).apply()
        PREFS.edit().remove(MAIL).apply()
        PREFS.edit().remove(PASSWORD).apply()
    }
}