package tomaszkopacz.meetbam.presenter

import com.google.firebase.auth.UserProfileChangeRequest
import tomaszkopacz.meetbam.dialogs.ProgressDialog
import tomaszkopacz.meetbam.interactor.AuthService
import tomaszkopacz.meetbam.view.MainApp
import tomaszkopacz.meetbam.view.PersonDataFragment
import tomaszkopacz.meetbam.view.PersonalisationActivity
import javax.inject.Inject

class PersonDataFragmentPresenter(private val fragment: PersonDataFragment) {

    @Inject
    lateinit var auth: AuthService

    private val progressDialog: ProgressDialog = ProgressDialog(fragment.activity)

    init {
        (fragment.activity!!.application as MainApp).component!!.inject(this)

        fragment.setMail(auth.getCurrentUser()!!.email!!)
    }

    fun skip(){
        (fragment.activity as PersonalisationActivity).changeLayout(PersonalisationActivity.PHOTO)
    }

    fun confirmUser(userFullName: String) {
        progressDialog.show()

        val firebaseUser = auth.getCurrentUser()
        val profileUpdaterBuilder = UserProfileChangeRequest.Builder()
                .setDisplayName(userFullName)
                .build()
        firebaseUser!!.updateProfile(profileUpdaterBuilder)

        progressDialog.dismiss()
        (fragment.activity as PersonalisationActivity).changeLayout(PersonalisationActivity.PHOTO)
    }
}