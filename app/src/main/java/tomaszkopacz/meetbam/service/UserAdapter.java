package tomaszkopacz.meetbam.service;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.presenters.RecyclerViewPresenter;

/**
 * Created by tomas on 07.04.2018.
 */

public class UserAdapter extends RecyclerView.Adapter {

    private RecyclerViewPresenter presenter;

    public UserAdapter(RecyclerViewPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        presenter.onItemBoundAtPosition(holder, position);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemCount();
    }
}
