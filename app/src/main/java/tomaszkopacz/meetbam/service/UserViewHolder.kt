package tomaszkopacz.meetbam.service

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotterknife.bindView
import tomaszkopacz.meetbam.R

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val username: TextView by bindView(R.id.username)
    val userImage: ImageView by bindView(R.id.user_image)
    val result: TextView by bindView(R.id.result)
}
