package tomaszkopacz.meetbam.view

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.LoginActivityPresenter

class LoginActivity : AppCompatActivity() {

    private lateinit var presenter: LoginActivityPresenter

    companion object {
        const val LOGIN_LAYOUT = 1
        const val REGISTER_LAYOUT = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginActivityPresenter(this)
        presenter.confirmUserIsSignedIn()

        sign_in_view_button.setOnClickListener {showLayout(LOGIN_LAYOUT)}
        sign_up_view_button.setOnClickListener {showLayout(REGISTER_LAYOUT)}
        sign_in_button.setOnClickListener {beginLogin()}
        sign_up_button.setOnClickListener {beginRegister()}
    }

    private fun showLayout(layout: Int){
        when(layout) {
            LOGIN_LAYOUT -> {
                sign_in_expandable.expand()
                sign_up_expandable.collapse()
                sign_in_view_button.typeface = Typeface.DEFAULT_BOLD
                sign_up_view_button.typeface = Typeface.DEFAULT
            }

            REGISTER_LAYOUT -> {
                sign_in_expandable.collapse()
                sign_up_expandable.expand()
                sign_in_view_button.typeface = Typeface.DEFAULT
                sign_up_view_button.typeface = Typeface.DEFAULT_BOLD
            }
        }
    }

    private fun beginLogin() {
        val mail = email_log_textview.text.toString()
        val password = password_log_textview.text.toString()
        presenter.submitLoginInput(mail, password)
    }

    private fun beginRegister() {
        val mail = email_reg_textview.text.toString()
        val password = password_reg_textview.text.toString()
        presenter.submitRegisterInput(mail, password)
    }

    fun showLoginError(error: Int){
        email_log_textview.error = null
        password_log_textview.error = null

        when (error){
            LoginActivityPresenter.ERROR_MAIL_EMPTY -> {
                email_log_textview.error = getString(R.string.mail_empty_error)
                email_log_textview.requestFocus()
            }

            LoginActivityPresenter.ERROR_PASSWORD_EMPTY -> {
                password_log_textview.error = getString(R.string.password_empty_error)
                password_log_textview.requestFocus()
            }

            LoginActivityPresenter.ERROR_MAIL_INVALID -> {
                email_log_textview.error = getString(R.string.mail_invalid_error)
                email_log_textview.requestFocus()
            }

            LoginActivityPresenter.ERROR_PASSWORD_TOO_SHORT -> {
                password_log_textview.error = getString(R.string.password_too_short_error)
                password_log_textview.requestFocus()
            }

            LoginActivityPresenter.FAIL_NO_SUCH_MAIL -> {
                email_log_textview.error = getString(R.string.no_such_user_error)
                email_log_textview.requestFocus()
            }

            LoginActivityPresenter.FAIL_PASSWORD_WRONG -> {
                password_log_textview.error = getString(R.string.wrong_password_error)
                password_log_textview.requestFocus()
            }

            LoginActivityPresenter.LOGIN_FAILED ->
                Toast.makeText(this,
                        getString(R.string.failure_login_error), Toast.LENGTH_SHORT).show()
        }
    }

    fun showRegisterError(error: Int){
        email_reg_textview.error = null
        password_reg_textview.error = null

        when (error){
            LoginActivityPresenter.ERROR_MAIL_EMPTY -> {
                email_reg_textview.error = getString(R.string.mail_empty_error)
                email_reg_textview.requestFocus()
            }

            LoginActivityPresenter.ERROR_PASSWORD_EMPTY -> {
                password_reg_textview.error = getString(R.string.password_empty_error)
                password_reg_textview.requestFocus()
            }

            LoginActivityPresenter.ERROR_MAIL_INVALID -> {
                email_reg_textview.error = getString(R.string.mail_invalid_error)
                email_reg_textview.requestFocus()
            }

            LoginActivityPresenter.ERROR_PASSWORD_TOO_SHORT -> {
                password_reg_textview.error = getString(R.string.password_too_short_error)
                password_reg_textview.requestFocus()
            }

            LoginActivityPresenter.ERROR_MAIL_OCCUPIED -> {
                email_reg_textview.error = getString(R.string.mail_occupied_error)
                email_reg_textview.requestFocus()
            }

            LoginActivityPresenter.REGISTER_FAILED -> {
                Toast.makeText(this, R.string.failure_register_error, Toast.LENGTH_LONG)
                        .show()
            }
        }
    }
}

