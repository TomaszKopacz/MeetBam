package tomaszkopacz.meetbam.presenter

import android.content.Intent
import com.google.firebase.auth.FirebaseAuth
import tomaszkopacz.meetbam.view.LoginActivity
import tomaszkopacz.meetbam.view.MainActivity


class MainActivityPresenter(private val activity: MainActivity) {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun logout() {
        auth.signOut()

        val intent = Intent(activity, LoginActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}