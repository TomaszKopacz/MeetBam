package tomaszkopacz.meetbam.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.LoginActivityPresenter

class LoginActivity : AppCompatActivity() {

    private lateinit var presenter: LoginActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginActivityPresenter(this)
        presenter.confirmUserIsSignedIn()

        email_sign_in_button.setOnClickListener {checkInput()}
    }

    private fun checkInput() {
        val mail = email_text_view.text.toString()
        val password = password_text_view.text.toString()
        presenter.submitInput(mail, password)
    }

    fun showError(error: Int){
        email_text_view.error = null
        password_text_view.error = null

        when (error){
            LoginActivityPresenter.MAIL_EMPTY -> {
                email_text_view.error = getString(R.string.mail_empty_error)
                email_text_view.requestFocus()
            }

            LoginActivityPresenter.PASSWORD_EMPTY -> {
                password_text_view.error = getString(R.string.password_empty_error)
                password_text_view.requestFocus()
            }

            LoginActivityPresenter.MAIL_INVALID -> {
                email_text_view.error = getString(R.string.mail_invalid_error)
                email_text_view.requestFocus()
            }

            LoginActivityPresenter.PASSWORD_TOO_SHORT -> {
                password_text_view.error = getString(R.string.password_too_short_error)
                password_text_view.requestFocus()
            }

            LoginActivityPresenter.NO_SUCH_MAIL -> {
                email_text_view.error = getString(R.string.no_such_user_error)
                email_text_view.requestFocus()
            }

            LoginActivityPresenter.PASSWORD_WRONG -> {
                password_text_view.error = getString(R.string.wrong_password_error)
                password_text_view.requestFocus()
            }

            LoginActivityPresenter.LOGIN_FAILED ->
                Toast.makeText(this,
                        getString(R.string.wrong_password_error), Toast.LENGTH_SHORT).show()
        }
    }
}

