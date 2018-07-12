package tomaszkopacz.meetbam.presenter

import android.support.v7.widget.RecyclerView
import android.view.View
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.entity.UserResult
import tomaszkopacz.meetbam.interactor.WebService
import tomaszkopacz.meetbam.service.UserAdapter
import tomaszkopacz.meetbam.view.MainApp
import tomaszkopacz.meetbam.view.StatsGlobalFragment
import java.util.*
import javax.inject.Inject


class StatsGlobalFragmentPresenter(private val fragment: StatsGlobalFragment)
    : RecyclerViewPresenter {

    //service
    @Inject lateinit var webService: WebService

    private val adapter = UserAdapter(this)
    private var results: MutableList<UserResult>? = ArrayList()

    init {
        (fragment.activity!!.application as MainApp)
                .webServiceComponent!!.inject(this)
    }

    fun downloadResults() {
        results!!.clear()

        val call = webService.globalResults
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
        holder.username.text =
                fragment.getString(R.string.user_at_position,
                        position + 1, result.name, result.surname)

        holder.result.text = fragment.getString(R.string.posts_number, result.result)
    }

    override fun onItemClick(view: View) {

    }

    override fun onLongItemClick(view: View) {

    }

    override fun itemCount(): Int{
        return results!!.size
    }
}
