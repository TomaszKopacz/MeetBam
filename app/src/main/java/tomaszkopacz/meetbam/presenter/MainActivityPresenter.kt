package tomaszkopacz.meetbam.presenter

import android.content.Intent
import com.google.firebase.auth.FirebaseAuth
import tomaszkopacz.meetbam.view.LoginActivity
import tomaszkopacz.meetbam.view.MainActivity
import tomaszkopacz.meetbam.view.MainApp
import javax.inject.Inject

class MainActivityPresenter(private val activity: MainActivity) {

    @Inject lateinit var auth: FirebaseAuth

    init {
        (activity.application as MainApp).component!!.inject(this)
    }

    fun logout() {
        auth.signOut()

        val intent = Intent(activity, LoginActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}