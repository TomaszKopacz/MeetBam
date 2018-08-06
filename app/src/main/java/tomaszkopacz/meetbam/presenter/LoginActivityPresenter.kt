package tomaszkopacz.meetbam.presenter

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tomaszkopacz.meetbam.entity.User
import tomaszkopacz.meetbam.interactor.WebService
import tomaszkopacz.meetbam.router.BluetoothRouter
import tomaszkopacz.meetbam.view.LoginActivity
import tomaszkopacz.meetbam.view.MainActivity
import tomaszkopacz.meetbam.view.MainApp
import javax.inject.Inject

class LoginActivityPresenter(private val activity: LoginActivity) {

    //service
    val app = activity.application as MainApp
    @Inject lateinit var webService: WebService

    companion object {

        val LOGIN_FAILED = -1

        val MAIL_EMPTY = 10
        val PASSWORD_EMPTY = 11
        val MAIL_INVALID = 12
        val PASSWORD_TOO_SHORT = 13

        val NO_SUCH_MAIL = 14
        val PASSWORD_WRONG = 15
    }

    init {
        (activity.application as MainApp).webServiceComponent!!.inject(this)
    }

    fun confirmUserIsSignedIn() {
        if (app.isUserLoggedIn())
            goToMainActivity()
    }

    fun submitInput(mail: String, password: String) {

        if (mail.isEmpty())
            activity.showError(MAIL_EMPTY)
        else if (password.isEmpty())
            activity.showError(PASSWORD_EMPTY)
        else if (!mail.contains("@"))
            activity.showError(MAIL_INVALID)
        else if (password.length < 6)
            activity.showError(PASSWORD_TOO_SHORT)
        else
            attemptLogin(mail, password)
    }

    private fun attemptLogin(mail: String, password: String) {
        val userTask = UserLoginTask(mail, password)
        userTask.execute()
    }

    @SuppressLint("StaticFieldLeak")
    private inner class UserLoginTask internal
        constructor(private val mEmail: String,
                    private val mPassword: String)
        : AsyncTask<Void, Void, Boolean>() {

        private var user: User? = null

        override fun doInBackground(vararg params: Void): Boolean? {

            val call = webService.getUser(mEmail)
            call.enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {

                    if (!response.body()!!.isEmpty()) {
                        user = response.body()!![0]

                        if (user!!.password == mPassword) {
                            login(user!!)

                        } else
                            activity.showError(PASSWORD_WRONG)

                    } else
                        activity.showError(NO_SUCH_MAIL)
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    activity.showError(LOGIN_FAILED)
                }
            })

            return true
        }

        override fun onPostExecute(success: Boolean?) {}

        override fun onCancelled() {}
    }

    private fun login(user: User) {
        val mail = user.mail
        val name = user.name
        val surname = user.surname
        val password = user.password
        app.login(mail!!, name!!, surname!!, password!!)

        updateUserLoggedOnDevice(mail)

        goToMainActivity()
    }

    private fun updateUserLoggedOnDevice(mail: String) {
        val device = BluetoothRouter.getRemoteAddress()
        val call = webService.updateLoggedState(device, mail)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {}

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }
        })
    }

    private fun goToMainActivity() {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}
