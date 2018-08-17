package tomaszkopacz.meetbam.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.PersonalisationActivityPresenter

class PersonalisationActivity : AppCompatActivity()  {

    private lateinit var presenter: PersonalisationActivityPresenter

    private val manager = supportFragmentManager

    companion object {
        const val PHOTO = 1
        const val DATA = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personalisation)

        presenter = PersonalisationActivityPresenter(this)

        changeLayout(DATA)
    }

    fun changeLayout(layout: Int) {
        val transaction = manager.beginTransaction()
        when(layout) {
            PHOTO -> {
                transaction.replace(R.id.personalisation_frame, PersonPhotoFragment() as Fragment)
            }

            DATA -> {
                transaction.replace(R.id.personalisation_frame, PersonDataFragment() as Fragment)
            }
        }
        transaction.commit()
    }

    fun goToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
