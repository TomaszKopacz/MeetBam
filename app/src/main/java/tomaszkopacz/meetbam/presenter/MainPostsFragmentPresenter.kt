package tomaszkopacz.meetbam.presenter

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_main_posts.*
import net.cachapa.expandablelayout.ExpandableLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.entity.Post
import tomaszkopacz.meetbam.interactor.WebService
import tomaszkopacz.meetbam.view.MainApp
import tomaszkopacz.meetbam.view.MainPostsFragment
import tomaszkopacz.meetbam.view.PostAdapter
import java.util.*
import javax.inject.Inject

class MainPostsFragmentPresenter(private val fragment: MainPostsFragment)
    : RecyclerViewPresenter {

    companion object {
        private val BASE_URL = "http://meetbam.cba.pl/"
    }

    //service
    val app = fragment.activity!!.application as MainApp
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

        val call = webService.getFriendsPosts(app.getLoggedUser().mail!!)
        call.enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                posts = response.body() as MutableList<Post>
                fragment.putPosts(adapter)
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
    }

    override fun onLongItemClick(view: View) {
        val dialog = Dialog(fragment.activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window.attributes.windowAnimations = R.style.DialogMeetBam

        val position = fragment.posts_recview.getChildAdapterPosition(view)
        val post = posts[position]
        val imageView = ImageView(fragment.activity)
        Glide.with(fragment.activity).load(BASE_URL + post.photo_dir).into(imageView)

        dialog.addContentView(imageView, RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT))

        dialog.show()
    }

    override fun itemCount(): Int {
        return posts.size
    }


    fun refresh() {
        downloadPosts()
    }
}
