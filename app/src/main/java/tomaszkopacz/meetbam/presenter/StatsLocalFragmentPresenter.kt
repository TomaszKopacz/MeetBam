package tomaszkopacz.meetbam.presenter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.user_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.entity.UserResult
import tomaszkopacz.meetbam.interactor.WebService
import tomaszkopacz.meetbam.view.MainApp
import tomaszkopacz.meetbam.view.StatsLocalFragment
import tomaszkopacz.meetbam.view.UserAdapter
import java.util.*
import javax.inject.Inject

class StatsLocalFragmentPresenter(private val fragment: StatsLocalFragment)
    : RecyclerViewPresenter {

    //service
    val app = fragment.activity!!.application as MainApp
    @Inject lateinit var webService: WebService

    private val adapter: UserAdapter = UserAdapter(this)
    private var results: MutableList<UserResult>? = ArrayList()

    init {
        (fragment.activity!!.application as MainApp)
                .component!!.inject(this)
    }

    fun downloadResults() {
        results!!.clear()

        val call = webService.getLocalResults(app.getLoggedUser().mail!!)
        call.enqueue(object : Callback<List<UserResult>> {
            override fun onResponse(call: Call<List<UserResult>>, response: Response<List<UserResult>>) {
                results = response.body() as MutableList<UserResult>?
                fragment.putResults(adapter)
            }

            override fun onFailure(call: Call<List<UserResult>>, t: Throwable) {

            }
        })
    }

    override fun onItemBoundAtPosition(holder: RecyclerView.ViewHolder, position: Int) {
        val result = results!![position]
        holder as UserAdapter.UserViewHolder
        holder.itemView.username.text =
                fragment.getString(R.string.user_at_position,
                        position + 1, result.name, result.surname)

        holder.itemView.result.text = fragment.getString(R.string.posts_number, result.result)
    }

    override fun onItemClick(view: View) {

    }

    override fun onLongItemClick(view: View) {

    }

    override fun itemCount(): Int {
        return results!!.size
    }
}
