package tomaszkopacz.meetbam.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.model.Post;
import tomaszkopacz.meetbam.model.User;
import tomaszkopacz.meetbam.presenters.AccountFriendsFragmentPresenter;
import tomaszkopacz.meetbam.service.PostAdapter;
import tomaszkopacz.meetbam.service.UserAdapter;
import tomaszkopacz.meetbam.service.WebService;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFriendsFragment extends Fragment {

    private AccountFriendsFragmentPresenter presenter;

    @Inject
    WebService service;

    @BindView(R.id.usersRecView)
    RecyclerView recyclerView;

    private UserAdapter userAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account_friends, container, false);

        //bind view
        ButterKnife.bind(this, view);

        //get dependencies
        ((MainApp)getActivity().getApplication())
                .getWebServiceComponent().inject(this);

        //set up presenter
        presenter = new AccountFriendsFragmentPresenter(this, service);

        //prepare recycler view and download posts
        prepareRecView();
        presenter.downloadPostsList();

        return view;
    }

    /**
     * Configures recycler view.
     */
    private void prepareRecView(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    /**
     * Puts users stored in adapter into recycler view list.
     * @param adapter
     */
    public void putUsers(UserAdapter adapter){
        recyclerView.setAdapter(adapter);
    }

    /**
     * Returns recycler view.
     * @return
     */
    public RecyclerView getRecyclerView(){
        return recyclerView;
    }
}
