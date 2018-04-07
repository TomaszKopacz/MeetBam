package tomaszkopacz.meetbam.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.presenters.StatsGlobalFragmentPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatsGlobalFragment extends Fragment {

    private StatsGlobalFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stats_global, container, false);

        //set up presenter
        presenter = new StatsGlobalFragmentPresenter(this);

        return view;
    }

}
