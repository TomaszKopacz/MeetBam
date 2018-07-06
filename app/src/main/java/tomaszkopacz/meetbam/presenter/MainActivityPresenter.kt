package tomaszkopacz.meetbam.presenter

import android.content.Intent
import tomaszkopacz.meetbam.service.CameraService
import tomaszkopacz.meetbam.service.LoginService
import tomaszkopacz.meetbam.view.LoginActivity
import tomaszkopacz.meetbam.view.MainActivity


class MainActivityPresenter(private val activity: MainActivity){

    private var mLoginService = LoginService(activity.applicationContext)
    fun logout() {
        mLoginService.logout()

        val intent = Intent(activity, LoginActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    fun takePhoto(service: CameraService) {
        service.takePhoto()
    }
}