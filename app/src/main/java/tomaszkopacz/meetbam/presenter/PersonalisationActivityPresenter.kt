package tomaszkopacz.meetbam.presenter

import android.content.Intent
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import tomaszkopacz.meetbam.view.MainActivity
import tomaszkopacz.meetbam.view.MainApp
import tomaszkopacz.meetbam.view.PersonalisationActivity
import javax.inject.Inject

class PersonalisationActivityPresenter (val activity: PersonalisationActivity) {

    @Inject lateinit var auth: FirebaseAuth

    init {
        (activity.application as MainApp).component!!.inject(this)
    }

    fun getRegisteredUser() : FirebaseUser {
        return auth.currentUser!!
    }

    fun confirmUser(user: String) {
        val firebaseUser = getRegisteredUser()
        val profileUpdaterBuilder = UserProfileChangeRequest.Builder()
                .setDisplayName(user)
                .build()

        firebaseUser.updateProfile(profileUpdaterBuilder)
        goToMainActivity()
    }

    private fun goToMainActivity() {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}