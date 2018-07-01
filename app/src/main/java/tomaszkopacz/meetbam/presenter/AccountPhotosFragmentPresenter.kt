package tomaszkopacz.meetbam.presenter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.entity.Post
import tomaszkopacz.meetbam.interactor.WebService
import tomaszkopacz.meetbam.service.LoginService
import tomaszkopacz.meetbam.service.PostAdapter
import tomaszkopacz.meetbam.service.PostTimeProvider
import tomaszkopacz.meetbam.service.PostViewHolder
import tomaszkopacz.meetbam.view.AccountPhotosFragment
import tomaszkopacz.meetbam.view.MainApp
import java.util.*
import javax.inject.Inject

class AccountPhotosFragmentPresenter(private val fragment: AccountPhotosFragment)
    : RecyclerViewPresenter {

    //service
    @Inject lateinit var webService: WebService
    private val mLoginService = LoginService(fragment.activity!!.applicationContext)

    //posts
    private val adapter = PostAdapter(this)
    private var photos: MutableList<Post>? = ArrayList()

    companion object {
        private val BASE_URL = "http://meetbam.cba.pl/"
    }

    init {
        (fragment.activity!!.application as MainApp)
                .webServiceComponent!!.inject(this)
    }

    fun downloadPostsList() {

        photos!!.clear()

        val call = webService.getUserPosts(mLoginService.getLoggedUser().mail!!)
        call.enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

                photos = response.body() as MutableList<Post>?
                fragment.putPhotos(adapter)
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }
        })
    }

    override fun onItemBoundAtPosition(holder: RecyclerView.ViewHolder, position: Int) {
        val post = photos!![position]

        holder as PostViewHolder
        holder.name1.text = fragment.getString(R.string.custom_user, post.name1, post.surname1)
        holder.name2.text = fragment.getString(R.string.custom_user, post.name2, post.surname2)

        Glide
                .with(fragment)
                .load(BASE_URL + post.photo_dir!!)
                .into(holder.photo)

        val timeAgo = PostTimeProvider
                .countTimeAgoInMin(post.time!!)
        val timeAgoText = PostTimeProvider
                .getCustomTimeAgoText(timeAgo, PostTimeProvider.FORMAT_MINS)
        holder.time.text = timeAgoText
    }

    override fun onItemClick(view: View) {

    }

    override fun itemCount(): Int {
        return photos!!.size
    }
}
