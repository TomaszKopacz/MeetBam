package tomaszkopacz.meetbam.service

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.post_item.view.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.entity.Post
import tomaszkopacz.meetbam.presenter.RecyclerViewPresenter


class PostAdapter(private val presenter: RecyclerViewPresenter)
    : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : PostViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.post_item, parent, false)

        view.setOnClickListener{
            presenter.onItemClick(view)
        }

        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        presenter.onItemBoundAtPosition(holder, position)
    }

    fun setContent(context: Context, holder: PostViewHolder, post: Post, photoUrl: String) {
        holder.itemView.name1_textview.text = context.getString(
                R.string.post_user, post.name1, post.surname1)
        holder.itemView.name2_textview.text = context.getString(
                R.string.post_user, post.name2, post.surname2)

        Glide
                .with(context)
                .load(photoUrl + post.photo_dir)
                .into(holder.itemView.post_imageview)

        val timeAgo = TimeAgoTextProvider.countTimeAgoInMin(post.time!!)
        val timeAgoText = TimeAgoTextProvider.getCustomTimeAgoText(timeAgo,
                TimeAgoTextProvider.FORMAT_MINUTES)
        holder.itemView.post_time_textview.text = context.getString(R.string.post_time, timeAgoText)
    }

    override fun getItemCount(): Int {
        return presenter.itemCount()
    }

    inner class PostViewHolder (itemView: View)
        : RecyclerView.ViewHolder(itemView)
}
