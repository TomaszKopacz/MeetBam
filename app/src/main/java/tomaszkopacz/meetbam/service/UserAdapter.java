package tomaszkopacz.meetbam.service;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.model.User;

/**
 * Created by tomas on 07.04.2018.
 */

public class UserAdapter extends RecyclerView.Adapter {

    private List<User> users = new ArrayList<>();
    private RecyclerView recView;

    public UserAdapter(List<User> users, RecyclerView recView){
        this.users = users;
        this.recView = recView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        User user = users.get(position);

        ((UserViewHolder)holder).username.setText(user.getName() + " " + user.getSurname());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
