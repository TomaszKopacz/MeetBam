package tomaszkopacz.meetbam.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_person_data.*

import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.PersonDataFragmentPresenter

class PersonDataFragment : Fragment() {

    private lateinit var presenter: PersonDataFragmentPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_person_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = PersonDataFragmentPresenter(this)

        confirm_personalisation_button.setOnClickListener { confirmUser() }

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
