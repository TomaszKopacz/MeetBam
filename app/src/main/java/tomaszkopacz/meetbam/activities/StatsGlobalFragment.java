package tomaszkopacz.meetbam.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.presenters.StatsGlobalFragmentPresenter;
import tomaszkopacz.meetbam.service.UserAdapter;
import tomaszkopacz.meetbam.service.WebService;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatsGlobalFragment extends Fragment {

    private StatsGlobalFragmentPresenter presenter;

    @Inject
    WebService service;

    @BindView(R.id.stats_global)
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stats_global, container, false);

        // bind views
        ButterKnife.bind(this, view);

        // get dependencies
        ((MainApp)getActivity().getApplication())
                .getWebServiceComponent().inject(this);

        //set up presenter
        presenter = new StatsGlobalFragmentPresenter(this, service);

        //prepare recycler view and download posts
        prepareRecView();
        presenter.downloadResults();

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
    public void putResults(UserAdapter adapter){
        recyclerView.setAdapter(adapter);
    }
}
