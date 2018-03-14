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

public class AccountActivity extends AppCompatActivity {

    @Inject
    AccountInfoFragment mAccountInfoFragment;

    @Inject
    AccountPhotosFragment mAccountPhotosFragment;

    @Inject
    AccountFriendsFragment mAccountFriendsFragment;

    @BindView(R.id.account_toolbar)
    Toolbar toolbar;

    @BindView(R.id.account_tabs)
    TabLayout tabs;

    @BindView(R.id.account_viewpager)
    ViewPager viewPager;

    private static final String ACCOUNT_TITLE = "ACCOUNT";
    private static final String PHOTOS_TITLE = "PHOTOS";
    private static final String FRIENDS_TITLE = "FRIENDS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

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

            //navigate to main activity
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
        adapter.addItem(mAccountInfoFragment, ACCOUNT_TITLE);
        adapter.addItem(mAccountPhotosFragment, PHOTOS_TITLE);
        adapter.addItem(mAccountFriendsFragment, FRIENDS_TITLE);

        viewPager.setAdapter(adapter);
    }
}
