package tomaszkopacz.meetbam.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.presenters.StatsLocalFragmentPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatsLocalFragment extends Fragment {

    @Inject
    StatsLocalFragmentPresenter presenter;

    @Inject
    public StatsLocalFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stats_local, container, false);

        //get dependencies
        ((MainApp)getActivity().getApplication()).getFragmentComponent().inject(this);

        //set up presenter
        presenter.setFragment(this);

        return view;
    }

}
