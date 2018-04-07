package tomaszkopacz.meetbam.presenters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tomaszkopacz.meetbam.activities.AccountFriendsFragment;
import tomaszkopacz.meetbam.model.Post;
import tomaszkopacz.meetbam.model.User;
import tomaszkopacz.meetbam.service.LoginService;
import tomaszkopacz.meetbam.service.UserAdapter;
import tomaszkopacz.meetbam.service.UserViewHolder;
import tomaszkopacz.meetbam.service.WebService;

/**
 * Created by tomas on 02.03.2018.
 */

public class AccountFriendsFragmentPresenter implements RecyclerViewPresenter{

    private AccountFriendsFragment fragment;
    private WebService mWebService;
    private LoginService mLoginService;

    // list of users
    private UserAdapter adapter;
    private List<User> users = new ArrayList<>();

    /**
     * Constructor.
     */
    public AccountFriendsFragmentPresenter (AccountFriendsFragment fragment, WebService service){
        this.fragment = fragment;
        this.mWebService = service;
        this.mLoginService = new LoginService(fragment.getActivity().getApplicationContext());
        this.adapter = new UserAdapter(this);
    }

    /**
     * Downloads posts and send them to activity.
     */
    public void downloadPostsList(){

        // remove previous elements
        users.clear();

        // when new elements downloaded
        Call call = mWebService.getFriends(mLoginService.getUserMail());
        call.enqueue(new Callback<List<User>>() {

            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                // assign response objects to list
                users = response.body();

                // send users to activity
                fragment.putUsers(adapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemBoundAtPosition(RecyclerView.ViewHolder holder, int position) {
        User user = users.get(position);
        ((UserViewHolder)holder).getUsername().setText(user.getName() + " " + user.getSurname());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
