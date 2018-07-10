package tomaszkopacz.meetbam.presenter

import android.support.v7.widget.RecyclerView
import android.view.View
import net.cachapa.expandablelayout.ExpandableLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.entity.Post
import tomaszkopacz.meetbam.interactor.WebService
import tomaszkopacz.meetbam.service.LoginService
import tomaszkopacz.meetbam.service.PostAdapter
import tomaszkopacz.meetbam.view.MainApp
import tomaszkopacz.meetbam.view.MainPostsFragment
import java.util.*
import javax.inject.Inject

class MainPostsFragmentPresenter(private val fragment: MainPostsFragment)
    : RecyclerViewPresenter{

    private val BASE_URL = "http://meetbam.cba.pl/"

    //service
    private var mLoginService = LoginService(fragment.activity!!.applicationContext)
    @Inject lateinit var webService: WebService

    //posts
    private var adapter = PostAdapter(this)
    private var posts: MutableList<Post> = ArrayList()

    init {
        (fragment.activity!!.application as MainApp)
                .webServiceComponent!!.inject(this)
    }

    fun downloadPosts() {
        posts.clear()

        val call = webService.getFriendsPosts(mLoginService.getLoggedUser().mail!!)
        call.enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                posts = response.body() as MutableList<Post>
                fragment.putPosts(adapter!!)
                fragment.refreshDone()
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                fragment.refreshDone()
            }
        })
    }

    override fun onItemBoundAtPosition(holder: RecyclerView.ViewHolder, position: Int) {
        val post = posts[position]
        holder as PostAdapter.PostViewHolder
        adapter.setContent(fragment.activity!!, holder, post, BASE_URL)
    }

    override fun onItemClick(view: View) {

        val e: ExpandableLayout = view.findViewById(R.id.main_expandable)
        e.toggle()

        //int position = fragment.getPostsRecView().getChildAdapterPosition(view);
        //posts.remove(position);
        //adapter.notifyItemRemoved(position);
    }

    override fun itemCount(): Int {
        return posts.size
    }


    fun refresh(){
        downloadPosts()
    }
}
