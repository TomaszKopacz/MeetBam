package tomaszkopacz.meetbam.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tomaszkopacz.meetbam.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFriendsFragment extends Fragment {


    public AccountFriendsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account_friends, container, false);
    }

}
