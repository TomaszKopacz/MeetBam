package tomaszkopacz.meetbam.presenter

import android.support.v7.widget.RecyclerView
import android.view.View
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tomaszkopacz.meetbam.entity.Post
import tomaszkopacz.meetbam.interactor.WebService
import tomaszkopacz.meetbam.view.AccountPhotosFragment
import tomaszkopacz.meetbam.view.MainApp
import tomaszkopacz.meetbam.view.PostAdapter
import java.util.*
import javax.inject.Inject

class AccountPhotosFragmentPresenter(private val fragment: AccountPhotosFragment)
    : RecyclerViewPresenter {

    //service
    @Inject lateinit var webService: WebService
    val app = fragment.activity!!.application as MainApp

    //posts
    private var adapter = PostAdapter(this)
    private var photos: MutableList<Post>? = ArrayList()

    companion object {
        private val BASE_URL = "http://meetbam.cba.pl/"
    }

    init {
        (fragment.activity!!.application as MainApp)
                .component!!.inject(this)
    }

    fun downloadPostsList() {

        photos!!.clear()

        val call = webService.getUserPosts(app.getLoggedUser().mail!!)
        call.enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

                photos = response.body() as MutableList<Post>
                fragment.putPhotos(adapter!!)
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }
        })
    }

    override fun onItemBoundAtPosition(holder: RecyclerView.ViewHolder, position: Int) {
        val post = photos!![position]
        holder as PostAdapter.PostViewHolder
        adapter.setContent(fragment.context!!, holder, post, BASE_URL)
    }

    override fun onItemClick(view: View) {

    }

    override fun onLongItemClick(view: View) {

    }

    override fun itemCount(): Int {
        return photos!!.size
    }
}
