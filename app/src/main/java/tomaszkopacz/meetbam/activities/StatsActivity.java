package tomaszkopacz.meetbam.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.service.ViewPagerAdapter;

public class StatsActivity extends AppCompatActivity {

    @Inject
    StatsLocalFragment mStatsLocalFragment;

    @Inject
    StatsGlobalFragment mStatsGlobalFragment;

    @BindView(R.id.stats_toolbar)
    Toolbar toolbar;

    @BindView(R.id.stats_tabs)
    TabLayout tabs;

    @BindView(R.id.stats_viewpager)
    ViewPager viewPager;

    //tabs titles
    private static final String LOCAL_RANKING_TITLE = "LOCAL";
    private static final String GLOBAL_RANKING_TITLE = "GLOBAL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        //bind views
        ButterKnife.bind(this);

        //get dependencies
        ((MainApp)getApplication()).getFragmentComponent().inject(this);

        //toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //view pager
        setUpViewPager(viewPager);

        //tab layout
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            //navigate to main
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Sets fragments as tabs.
     * @param viewPager view, to which tabs adapter is assigned
     */
    private void setUpViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addItem(mStatsLocalFragment, LOCAL_RANKING_TITLE);
        adapter.addItem(mStatsGlobalFragment, GLOBAL_RANKING_TITLE);

        viewPager.setAdapter(adapter);
    }
}
