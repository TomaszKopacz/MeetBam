package tomaszkopacz.meetbam.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
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

        sign_in_view_button.setOnClickListener{
            sign_in_expandable.expand()
            sign_up_expandable.collapse()
            fb_login_button.visibility = View.VISIBLE
        }

        sign_up_view_button.setOnClickListener {
            sign_up_expandable.expand()
            sign_in_expandable.collapse()
            fb_login_button.visibility = View.GONE
        }

        sign_in_button.setOnClickListener {checkInput(LOGIN_LAYOUT)}
        sign_up_button.setOnClickListener {checkInput(REGISTER_LAYOUT)}
    }

    private fun checkInput(state: Int) {
        when (state) {
            LOGIN_LAYOUT -> {
                val mail = email_text_view.text.toString()
                val password = password_text_view.text.toString()
                presenter.submitInput(mail, password)
            }

            REGISTER_LAYOUT -> {
                Toast.makeText(this, "REGISTARTION", Toast.LENGTH_LONG).show()
            }
        }

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

