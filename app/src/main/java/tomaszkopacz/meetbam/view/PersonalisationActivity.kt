package tomaszkopacz.meetbam.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.PersonalisationActivityPresenter

class PersonalisationActivity : AppCompatActivity()  {

    private lateinit var presenter: PersonalisationActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personalisation)

        presenter = PersonalisationActivityPresenter(this)

        initLayout()
    }

    private fun initLayout() {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.personalisation_frame, PersonDataFragment() as Fragment)
        transaction.commit()
    }
}
