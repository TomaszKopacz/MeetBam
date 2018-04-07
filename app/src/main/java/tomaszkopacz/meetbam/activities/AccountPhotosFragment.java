package tomaszkopacz.meetbam.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.model.Post;
import tomaszkopacz.meetbam.presenters.AccountPhotosFragmentPresenter;
import tomaszkopacz.meetbam.service.PostAdapter;
import tomaszkopacz.meetbam.service.WebService;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountPhotosFragment extends Fragment {

    private AccountPhotosFragmentPresenter presenter;

    @Inject
    WebService service;

    @BindView(R.id.userPostsRecView)
    RecyclerView recView;

    private PostAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflate the layout for this fragment
        View view
                = inflater.inflate(R.layout.fragment_account_photos, container, false);

        //bind views
        ButterKnife.bind(this, view);

        //get dependencies
        ((MainApp)(getActivity().getApplication()))
                .getWebServiceComponent().inject(this);

        //set up presenter
        presenter = new AccountPhotosFragmentPresenter(this, service);

        //prepare recycler view and download posts
        prepareRecView();
        presenter.downloadPostsList();

        return view;
    }

    /**
     * Configures recycler view. Recycler has fixed size, two spans oriented vertically
     * and default item animator.
     */
    private void prepareRecView(){
        recView.setHasFixedSize(true);
        recView.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
        recView.setItemAnimator(new DefaultItemAnimator());
    }

    /**
     * Sets list of posts to recycler view.
     */
    public void setUpList(List<Post> posts) {
        if (posts == null)
            posts = new ArrayList<>();

        adapter = new PostAdapter(this.getActivity(), posts, recView);
        recView.setAdapter(adapter);
    }
}
