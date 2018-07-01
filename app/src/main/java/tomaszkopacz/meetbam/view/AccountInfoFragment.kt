package tomaszkopacz.meetbam.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.AccountInfoFragmentPresenter

class AccountInfoFragment : Fragment() {

    private lateinit var presenter: AccountInfoFragmentPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        presenter = AccountInfoFragmentPresenter(this)
        return inflater.inflate(R.layout.fragment_account_info, container, false)
    }
}
