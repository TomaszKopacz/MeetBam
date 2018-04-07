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
import tomaszkopacz.meetbam.service.LoginService;
import tomaszkopacz.meetbam.service.ViewPagerAdapter;

public class AccountActivity extends AppCompatActivity {

    private AccountInfoFragment mAccountInfoFragment;
    private AccountPhotosFragment mAccountPhotosFragment;
    private AccountFriendsFragment mAccountFriendsFragment;

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

        //toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // set title: user name and surname
        setTitle();

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
     * Sets title of activity bar. The title is name and surname of a logged user.
     */
    private void setTitle(){
        LoginService service = new LoginService(getApplicationContext());
        setTitle(service.getUserName() + " " + service.getUserSurname());
    }

    /**
     * Sets fragments as tabs.
     * @param viewPager view, to which tabs adapter is assigned
     */
    private void setUpViewPager(ViewPager viewPager){
        mAccountInfoFragment = new AccountInfoFragment();
        mAccountPhotosFragment = new AccountPhotosFragment();
        mAccountFriendsFragment = new AccountFriendsFragment();

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addItem(mAccountInfoFragment, ACCOUNT_TITLE);
        adapter.addItem(mAccountPhotosFragment, PHOTOS_TITLE);
        adapter.addItem(mAccountFriendsFragment, FRIENDS_TITLE);

        viewPager.setAdapter(adapter);
    }
}
