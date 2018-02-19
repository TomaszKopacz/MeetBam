package tomaszkopacz.meetbam.tabs_service;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomas on 19.02.2018.
 * Adapter holding fragments and their titles.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragments = new ArrayList<>();
    private final List<String> titles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    /**
     * Adds new fragment and its tab title.
     * @param fragment
     * @param title
     */
    public void addItem(Fragment fragment, String title){
        fragments.add(fragment);
        titles.add(title);
    }
}
