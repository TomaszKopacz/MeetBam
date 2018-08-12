package tomaszkopacz.meetbam.presenter

import android.content.Intent
import tomaszkopacz.meetbam.interactor.AuthService
import tomaszkopacz.meetbam.view.LoginActivity
import tomaszkopacz.meetbam.view.MainActivity
import tomaszkopacz.meetbam.view.MainApp
import javax.inject.Inject

class MainActivityPresenter(private val activity: MainActivity) {

    @Inject lateinit var authService: AuthService

    init {
        (activity.application as MainApp).component!!.inject(this)
    }

    fun logout() {
        authService.logout()

        val intent = Intent(activity, LoginActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}