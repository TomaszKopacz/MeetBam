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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_main_posts.*
import net.cachapa.expandablelayout.ExpandableLayout
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.entity.Post
import tomaszkopacz.meetbam.interactor.DatabaseService
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
    @Inject lateinit var auth: FirebaseAuth
    @Inject lateinit var database: DatabaseService

    //posts
    private var adapter = PostAdapter(this)
    private var posts: MutableList<Post> = ArrayList()

    init {
        (fragment.activity!!.application as MainApp).component!!.inject(this)
    }

    fun downloadPosts() {

        val ref = database.getPostsReference()
        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                fragment.refreshDone()

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                posts.clear()

                for (obj in snapshot.children){
                    val databasePost = obj.getValue(Post::class.java)
                    databasePost!!

                    val post = Post()
                    post.name1 = databasePost.name1
                    post.name2 = databasePost.name2
                    post.url = databasePost.url
                    post.time = databasePost.time

                    posts.add(post)
                    fragment.refreshDone()
                    fragment.putPosts(adapter)
                }
            }
        })
    }

    override fun onItemBoundAtPosition(holder: RecyclerView.ViewHolder, position: Int) {
        val post = posts[position]
        holder as PostAdapter.PostViewHolder
        adapter.setContent(fragment.activity!!, holder, post)
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
        Glide.with(fragment.activity!!).load(BASE_URL + post.url).into(imageView)

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
