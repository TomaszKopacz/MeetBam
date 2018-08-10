package tomaszkopacz.meetbam.presenter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.user_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.entity.User
import tomaszkopacz.meetbam.interactor.WebService
import tomaszkopacz.meetbam.view.AccountFriendsFragment
import tomaszkopacz.meetbam.view.MainApp
import tomaszkopacz.meetbam.view.UserAdapter
import java.util.*
import javax.inject.Inject

class AccountFriendsFragmentPresenter(private val fragment: AccountFriendsFragment)
    : RecyclerViewPresenter {

    //service
    val app = fragment.activity!!.application as MainApp
    @Inject lateinit var webService: WebService

    //friends
    private val adapter = UserAdapter(this)
    private var users: MutableList<User>? = ArrayList()

    init {
        (fragment.activity!!.application as MainApp)
                .component!!.inject(this)
    }

    fun downloadPostsList() {

        users!!.clear()

        val call = webService.getFriends(app.getLoggedUser().mail!!)
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
        holder.itemView.username.text = fragment.getString(R.string.custom_user, user.name, user.surname)
    }

    override fun onItemClick(view: View) {

    }

    override fun onLongItemClick(view: View) {

    }

    override fun itemCount(): Int {
        return users!!.size
    }
}
