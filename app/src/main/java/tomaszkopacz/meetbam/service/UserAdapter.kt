package tomaszkopacz.meetbam.service

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotterknife.bindView
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.RecyclerViewPresenter

class UserAdapter(private val presenter: RecyclerViewPresenter)
    : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.user_item, parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        presenter.onItemBoundAtPosition(holder, position)
    }

    override fun getItemCount(): Int {
        return presenter.itemCount()
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val username: TextView by bindView(R.id.username)
        val userImage: ImageView by bindView(R.id.user_image)
        val result: TextView by bindView(R.id.result)
    }
}
