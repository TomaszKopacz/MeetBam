package tomaszkopacz.meetbam.presenter

import android.support.v7.widget.RecyclerView
import android.view.View

interface RecyclerViewPresenter {

    fun onItemBoundAtPosition(holder: RecyclerView.ViewHolder, position: Int)
    fun onItemClick(view: View)
    fun itemCount(): Int
}
