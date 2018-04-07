package tomaszkopacz.meetbam.presenters;

import android.support.v7.widget.RecyclerView;

/**
 * Created by tomas on 07.04.2018.
 */

public interface RecyclerViewPresenter {

    void onItemBoundAtPosition(RecyclerView.ViewHolder holder, int position);
    int getItemCount();
}
