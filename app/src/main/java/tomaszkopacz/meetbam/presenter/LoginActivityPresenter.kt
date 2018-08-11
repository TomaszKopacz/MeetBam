package tomaszkopacz.meetbam.presenter

import android.content.Intent
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import tomaszkopacz.meetbam.interactor.WebService
import tomaszkopacz.meetbam.view.LoginActivity
import tomaszkopacz.meetbam.view.MainActivity
import tomaszkopacz.meetbam.view.MainApp
import tomaszkopacz.meetbam.view.PersonalisationActivity
import javax.inject.Inject

class LoginActivityPresenter(private val activity: LoginActivity) {

    //service
    @Inject lateinit var webService: WebService
    @Inject lateinit var auth: FirebaseAuth

    companion object {
        //input incorrect
        const val ERROR_MAIL_EMPTY = 10
        const val ERROR_PASSWORD_EMPTY = 11
        const val ERROR_MAIL_INVALID = 12
        const val ERROR_PASSWORD_TOO_SHORT = 13

        //login error
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
        if (auth.currentUser != null)
            goToMainActivity()
    }

    fun submitLoginInput(mail: String, password: String) {

        if (mail.isEmpty())
            activity.showLoginError(ERROR_MAIL_EMPTY)
        else if (password.isEmpty())
            activity.showLoginError(ERROR_PASSWORD_EMPTY)
        else if (!mail.contains("@"))
            activity.showLoginError(ERROR_MAIL_INVALID)
        else if (password.length < 6)
            activity.showLoginError(ERROR_PASSWORD_TOO_SHORT)
        else
            attemptLogin(mail, password)
    }

    private fun attemptLogin(mail: String, password: String) {
        auth.signInWithEmailAndPassword(mail, password)
                .addOnCompleteListener(activity){
                    when {
                        it.isSuccessful -> {
                            goToMainActivity()
                        }

                        else -> {
                            activity.showLoginError(LOGIN_FAILED)
                        }
                    }
                }
    }

    fun submitRegisterInput(mail: String, password: String) {
        if (mail.isEmpty())
            activity.showRegisterError(ERROR_MAIL_EMPTY)
        else if (password.isEmpty())
            activity.showRegisterError(ERROR_PASSWORD_EMPTY)
        else if (!mail.contains("@"))
            activity.showRegisterError(ERROR_MAIL_INVALID)
        else if (password.length < 6)
            activity.showRegisterError(ERROR_PASSWORD_TOO_SHORT)
        else
            attemptRegister(mail, password)
    }

    private fun attemptRegister(mail: String, password: String) {
        auth.createUserWithEmailAndPassword(mail, password)
                .addOnCompleteListener(activity) {
                    when {
                        it.isSuccessful -> {
                            goToPersonalisationActivity()
                        }

                        it.exception is FirebaseAuthUserCollisionException -> {
                            activity.showRegisterError(ERROR_MAIL_OCCUPIED)
                        }

                        else -> {
                            activity.showRegisterError(REGISTER_FAILED)
                        }
                    }
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
