package tomaszkopacz.meetbam.presenter

import android.support.v7.widget.RecyclerView
import android.view.View
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.entity.User
import tomaszkopacz.meetbam.interactor.WebService
import tomaszkopacz.meetbam.service.LoginService
import tomaszkopacz.meetbam.service.UserAdapter
import tomaszkopacz.meetbam.view.AccountFriendsFragment
import tomaszkopacz.meetbam.view.MainApp
import java.util.*
import javax.inject.Inject

class AccountFriendsFragmentPresenter(private val fragment: AccountFriendsFragment)
    : RecyclerViewPresenter {

    //service
    @Inject lateinit var webService: WebService

    private val mLoginService = LoginService(fragment.activity!!.applicationContext)

    //friends
    private val adapter = UserAdapter(this)
    private var users: MutableList<User>? = ArrayList()

    init {
        (fragment.activity!!.application as MainApp)
                .webServiceComponent!!.inject(this)
    }

    fun downloadPostsList() {

        users!!.clear()

        val call = webService.getFriends(mLoginService.getLoggedUser().mail!!)
        call.enqueue(object : Callback<List<User>> {

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                users = response.body() as MutableList<User>?
                fragment.putUsers(adapter)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }
        })
    }

    override fun onItemBoundAtPosition(holder: RecyclerView.ViewHolder, position: Int) {
        val user = users!![position]

        holder as UserAdapter.UserViewHolder
        holder.username.text = fragment.getString(R.string.custom_user, user.name, user.surname)
    }

    override fun onItemClick(view: View) {

    }

    override fun itemCount(): Int {
        return users!!.size
    }
}
