package tomaszkopacz.meetbam.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_account_friends.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.AccountFriendsFragmentPresenter
import tomaszkopacz.meetbam.service.UserAdapter

class AccountFriendsFragment : Fragment() {

    private lateinit var presenter: AccountFriendsFragmentPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_account_friends, container, false)

        presenter = AccountFriendsFragmentPresenter(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareRecView()
        presenter.downloadPostsList()
    }

    private fun prepareRecView() {
        user_friends_recview.layoutManager = LinearLayoutManager(activity)
        user_friends_recview.setHasFixedSize(true)
        user_friends_recview.itemAnimator = DefaultItemAnimator()
    }

    fun putUsers(adapter: UserAdapter) {
        user_friends_recview.adapter = adapter
    }
}
