package tomaszkopacz.meetbam.presenter

import android.content.Intent
import tomaszkopacz.meetbam.view.LoginActivity
import tomaszkopacz.meetbam.view.MainActivity
import tomaszkopacz.meetbam.view.MainApp


class MainActivityPresenter(private val activity: MainActivity) {

    val app = activity.application as MainApp

    fun logout() {
        app.logout()

        val intent = Intent(activity, LoginActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}