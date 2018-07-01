package tomaszkopacz.meetbam.service

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.RecyclerViewPresenter

class UserAdapter(private val presenter: RecyclerViewPresenter)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.user_item, parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        presenter.onItemBoundAtPosition(holder, position)
    }

    override fun getItemCount(): Int {
        return presenter.itemCount()
    }
}
