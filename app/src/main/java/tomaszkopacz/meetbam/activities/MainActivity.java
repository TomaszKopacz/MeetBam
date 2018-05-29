package tomaszkopacz.meetbam.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.presenters.MainActivityPresenter;
import tomaszkopacz.meetbam.service.PostAdapter;
import tomaszkopacz.meetbam.service.WebService;

public class MainActivity extends AppCompatActivity {

    private MainActivityPresenter presenter;

    @Inject
    WebService service;

    @BindView(R.id.toolbar_main)
    Toolbar toolbar;

    @BindView(R.id.postsRecView)
    RecyclerView postsRecView;

    @BindView(R.id.fab_main)
    FloatingActionButton fab;

    public static final int CAMERA_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind views
        ButterKnife.bind(this);

        //action bar
        setSupportActionBar(toolbar);

        //get dependencies
        ((MainApp)getApplication()).getWebServiceComponent().inject(this);

        //set up presenter
        presenter = new MainActivityPresenter(this, service);

        //prepare recycler view and download posts
        prepareRecView();
        presenter.downloadPostsListToActivity();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_user:
                Intent user_intent = new Intent(this, AccountActivity.class);
                startActivity(user_intent);
                break;

            case R.id.action_stats:
                Intent stats_intent = new Intent(this, StatsActivity.class);
                startActivity(stats_intent);
                break;

            case R.id.action_map:
                Intent map_intent = new Intent(this, MapActivity.class);
                startActivity(map_intent);
                break;

            case R.id.action_search:
                Intent search_intent = new Intent(this, SearchActivity.class);
                startActivity(search_intent);
                break;

            case R.id.action_logout:
                presenter.logout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab_main)
    public void onFabClick(View view){
        presenter.photoAttempt();
    }

    /**
     * Configures recycler view. Recycler has fixed size, two spans oriented vertically
     * and default item animator.
     */
    private void prepareRecView(){
        postsRecView.setHasFixedSize(true);
        postsRecView.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
        postsRecView.setItemAnimator(new DefaultItemAnimator());
    }

    /**
     * Puts posts stored in adapter into recycler view list.
     * @param adapter
     */
    public void putPosts(PostAdapter adapter){
        postsRecView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // when picture is taken
        if (requestCode == CAMERA_CODE && resultCode == RESULT_OK){
            presenter.afterPhotoTaken();
        }
    }

    /**
     * @return recycler view for post items
     */
    public RecyclerView getPostsRecView(){
        return postsRecView;
    }
}
