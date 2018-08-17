package tomaszkopacz.meetbam.presenter

import android.content.Intent
import tomaszkopacz.meetbam.dialogs.ProgressDialog
import tomaszkopacz.meetbam.interactor.AuthService
import tomaszkopacz.meetbam.interactor.TaskListener
import tomaszkopacz.meetbam.interactor.WebService
import tomaszkopacz.meetbam.view.LoginActivity
import tomaszkopacz.meetbam.view.MainActivity
import tomaszkopacz.meetbam.view.MainApp
import tomaszkopacz.meetbam.view.PersonalisationActivity
import javax.inject.Inject

class LoginActivityPresenter(private val activity: LoginActivity) {

    //service
    @Inject lateinit var webService: WebService
    @Inject lateinit var authService: AuthService

    private val progressDialog: ProgressDialog = ProgressDialog(activity)

    companion object {
        //input incorrect
        const val ERROR_MAIL_EMPTY = 10
        const val ERROR_PASSWORD_EMPTY = 11
        const val ERROR_MAIL_INVALID = 12
        const val ERROR_PASSWORD_TOO_SHORT = 13

        //loginUser error
        const val LOGIN_FAILED = -1
        const val FAIL_NO_SUCH_MAIL = 14
        const val FAIL_PASSWORD_WRONG = 15

        //register error
        const val REGISTER_FAILED = -2
        const val ERROR_MAIL_OCCUPIED = 16
    }

    init {
        (activity.application as MainApp).component!!.inject(this)
    }

    fun confirmUserIsSignedIn() {
        if (authService.getCurrentUser() != null)
            goToMainActivity()
    }

    fun submitLoginInput(mail: String, password: String) {

        val mMail = mail.trim()
        val mPassword = password.trim()

        if (mMail.isEmpty())
            activity.showLoginError(ERROR_MAIL_EMPTY)
        else if (mPassword.isEmpty())
            activity.showLoginError(ERROR_PASSWORD_EMPTY)
        else if (!mMail.contains("@"))
            activity.showLoginError(ERROR_MAIL_INVALID)
        else if (mPassword.length < 6)
            activity.showLoginError(ERROR_PASSWORD_TOO_SHORT)
        else
            attemptLogin(mMail, mPassword)
    }

    private fun attemptLogin(mail: String, password: String) {
        progressDialog.show()
        authService.loginUser(mail, password, loginListener)
    }

    private val loginListener = object : TaskListener{
        override fun onSucceed() {
            progressDialog.dismiss()
            goToMainActivity()
        }

        override fun onFailed() {
            progressDialog.dismiss()
            activity.showLoginError(LOGIN_FAILED)
        }
    }

    fun submitRegisterInput(mail: String, password: String) {

        val mMail = mail.trim()
        val mPassword = password.trim()

        if (mMail.isEmpty())
            activity.showRegisterError(ERROR_MAIL_EMPTY)
        else if (mPassword.isEmpty())
            activity.showRegisterError(ERROR_PASSWORD_EMPTY)
        else if (!mMail.contains("@"))
            activity.showRegisterError(ERROR_MAIL_INVALID)
        else if (mPassword.length < 6)
            activity.showRegisterError(ERROR_PASSWORD_TOO_SHORT)
        else
            attemptRegister(mMail, mPassword)
    }

    private fun attemptRegister(mail: String, password: String) {
        progressDialog.show()
        authService.registerUser(mail, password, registerListener)
    }

    private val registerListener = object : TaskListener {
        override fun onSucceed() {
            progressDialog.dismiss()
            goToPersonalisationActivity()
        }

        override fun onFailed() {
            progressDialog.dismiss()
            activity.showRegisterError(REGISTER_FAILED)
        }
    }

    private fun goToMainActivity() {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    private fun goToPersonalisationActivity() {
        val intent = Intent(activity, PersonalisationActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}
