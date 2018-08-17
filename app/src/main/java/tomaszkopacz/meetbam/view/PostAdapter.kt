package tomaszkopacz.meetbam.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.post_item.view.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.entity.Post
import tomaszkopacz.meetbam.interactor.StorageService
import tomaszkopacz.meetbam.presenter.RecyclerViewPresenter
import tomaszkopacz.meetbam.service.DateTimeCounter
import tomaszkopacz.meetbam.service.GlideApp


class PostAdapter(private val presenter: RecyclerViewPresenter)
    : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : PostViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.post_item, parent, false)

        view.setOnClickListener{
            presenter.onItemClick(view)
        }

        view.setOnLongClickListener{
            presenter.onLongItemClick(view)
            true
        }

        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        presenter.onItemBoundAtPosition(holder, position)
    }

    fun setContent(context: Context, holder: PostViewHolder, post: Post, service: StorageService) {
        holder.itemView.name1_textview.text = post.name1
        holder.itemView.name2_textview.text = post.name2
        holder.itemView.post_time_textview.text = post.time

        GlideApp
                .with(context)
                .load(service.getReference(post.url!!))
                .into(holder.itemView.post_imageview)

        val timeAgo = DateTimeCounter.countTimeAgo(post.time!!,
                DateTimeCounter.FORMAT_MINUTES)
        val timeAgoText = DateTimeCounter.getTimeAgoText(timeAgo,
                DateTimeCounter.FORMAT_MINUTES)
        holder.itemView.post_time_textview.text = context.getString(R.string.post_time, timeAgoText)
    }

    override fun getItemCount(): Int {
        return presenter.itemCount()
    }

    inner class PostViewHolder (itemView: View)
        : RecyclerView.ViewHolder(itemView)
}
