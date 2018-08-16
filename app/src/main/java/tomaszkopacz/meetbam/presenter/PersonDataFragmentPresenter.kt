package tomaszkopacz.meetbam.presenter

import android.content.Intent
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import tomaszkopacz.meetbam.dialogs.ProgressDialog
import tomaszkopacz.meetbam.view.MainActivity
import tomaszkopacz.meetbam.view.MainApp
import tomaszkopacz.meetbam.view.PersonDataFragment
import javax.inject.Inject

class PersonDataFragmentPresenter(private val fragment: PersonDataFragment) {

    @Inject
    lateinit var auth: FirebaseAuth

    private val progressDialog: ProgressDialog = ProgressDialog(fragment.activity)

    init {
        (fragment.activity!!.application as MainApp).component!!.inject(this)
    }

    fun getRegisteredUser() : FirebaseUser {
        return auth.currentUser!!
    }

    fun confirmUser(user: String) {
        progressDialog.show()

        val firebaseUser = getRegisteredUser()
        val profileUpdaterBuilder = UserProfileChangeRequest.Builder()
                .setDisplayName(user)
                .build()
        firebaseUser.updateProfile(profileUpdaterBuilder)

        progressDialog.dismiss()
        goToMainActivity()
    }

    private fun goToMainActivity() {
        val intent = Intent(fragment.activity, MainActivity::class.java)
        fragment.activity!!.startActivity(intent)
        fragment.activity!!.finish()
    }
}