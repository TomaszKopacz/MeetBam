package tomaszkopacz.meetbam.service;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.activities.MainActivity;
import tomaszkopacz.meetbam.model.Post;
import tomaszkopacz.meetbam.presenters.RecyclerViewPresenter;

/**
 * Created by tomas on 03.03.2018.
 * Creates dynamic recycler view list of posts.
 */

public class PostAdapter extends RecyclerView.Adapter {

    private RecyclerViewPresenter presenter;

    /**
     * Constructor.
     */
    public PostAdapter(RecyclerViewPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);

        // when item clicked remove it
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onItemClick(view);
            }
        });

        return new PostViewHolder(view);
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
