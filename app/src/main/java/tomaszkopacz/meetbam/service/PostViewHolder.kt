package tomaszkopacz.meetbam.service

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotterknife.bindView
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.entity.Post

class PostViewHolder(itemView: View)
    : RecyclerView.ViewHolder(itemView){

    val name1: TextView by bindView(R.id.name1)
    val name2: TextView by bindView(R.id.name2)
    val photo: ImageView by bindView(R.id.post_photo)
    val time: TextView by bindView(R.id.post_time)

    fun setContent(post: Post, activity: Activity, photoUrl: String) {
        name1!!.text = post.name1 + " " + post.surname1
        name2!!.text = post.name2 + " " + post.surname2

        Glide
                .with(activity)
                .load(photoUrl + post.photo_dir)
                .into(photo!!)

        val timeAgo = PostTimeProvider.countTimeAgoInMin(post.time!!)
        val timeAgoText = PostTimeProvider.getCustomTimeAgoText(timeAgo,
                PostTimeProvider.FORMAT_MINS)
        time!!.text = timeAgoText
    }
}
