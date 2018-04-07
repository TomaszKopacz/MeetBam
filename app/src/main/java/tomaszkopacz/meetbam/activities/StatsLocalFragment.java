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
import tomaszkopacz.meetbam.presenters.StatsLocalFragmentPresenter;
import tomaszkopacz.meetbam.service.UserAdapter;
import tomaszkopacz.meetbam.service.WebService;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatsLocalFragment extends Fragment {

    private StatsLocalFragmentPresenter presenter;

    @Inject
    WebService service;

    @BindView(R.id.stats_local)
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stats_local, container, false);

        // bind views
        ButterKnife.bind(this, view);

        // get dependencies
        ((MainApp)getActivity().getApplication())
                .getWebServiceComponent().inject(this);

        //set up presenter
        presenter = new StatsLocalFragmentPresenter(this, service);

        // set up recycler view and download results
        prepareRecyclerView();
        presenter.downloadResults();

        return view;
    }

    /**
     * Configures recycler view.
     */
    private void prepareRecyclerView(){
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
