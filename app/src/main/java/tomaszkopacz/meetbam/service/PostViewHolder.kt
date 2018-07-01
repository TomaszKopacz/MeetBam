package tomaszkopacz.meetbam.service

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.post_item.view.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.entity.Post

class PostViewHolder(itemView: View)
    : RecyclerView.ViewHolder(itemView){

    fun setContent(context: Context, post: Post, photoUrl: String) {
        itemView.name1_textview.text = context.getString(
                R.string.post_user, post.name1, post.surname1)
        itemView.name2_textview.text = context.getString(
                R.string.post_user, post.name2, post.surname2)

        Glide
                .with(context)
                .load(photoUrl + post.photo_dir)
                .into(itemView.post_photo_imageview)

        val timeAgo = TimeAgoTextProvider.countTimeAgoInMin(post.time!!)
        val timeAgoText = TimeAgoTextProvider.getCustomTimeAgoText(timeAgo,
                TimeAgoTextProvider.FORMAT_MINUTES)
        itemView.post_time_textview.text = context.getString(R.string.post_time, timeAgoText)
    }
}
