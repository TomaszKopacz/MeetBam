package tomaszkopacz.meetbam.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_personalisation.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.PersonalisationActivityPresenter

class PersonalisationActivity : AppCompatActivity() {

    private lateinit var presenter: PersonalisationActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personalisation)

        presenter = PersonalisationActivityPresenter(this)

        confirm_personalisation_button.setOnClickListener {
            confirmUser()
        }

        initLayout()
    }

    private fun initLayout() {
        val user = presenter.getRegisteredUser()
        person_mail_textview.text = user.email
    }

    private fun confirmUser() {
        val user = "${person_name_edittext.text} ${person_surname_edittext.text}"
        presenter.confirmUser(user)
    }
}
