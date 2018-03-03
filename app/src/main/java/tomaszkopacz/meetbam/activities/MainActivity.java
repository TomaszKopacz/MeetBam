package tomaszkopacz.meetbam.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tomaszkopacz.meetbam.R;
import tomaszkopacz.meetbam.model.Post;
import tomaszkopacz.meetbam.presenters.MainActivityPresenter;
import tomaszkopacz.meetbam.tabs_service.PostAdapter;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainActivityPresenter presenter;

    @BindView(R.id.toolbar_main)
    Toolbar toolbar;

    @BindView(R.id.postsRecView)
    RecyclerView postsRecView;

    @BindView(R.id.fab_main)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind views
        ButterKnife.bind(this);

        //action bar
        setSupportActionBar(toolbar);

        //get dependencies
        ((MainApp)getApplication()).getFragmentComponent().inject(this);
        ((MainApp)getApplication()).getWebServiceComponent().inject(this);

        //set up presenter
        presenter.setActivity(this);

        //when activity created, set up web service communication and download posts
        presenter.setUpWebService();
        presenter.getPostsList();
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

            case R.id.action_search:
                Intent search_intent = new Intent(this, SearchActivity.class);
                startActivity(search_intent);
                break;

            case R.id.action_logout:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab_main)
    public void onFabClick(View view){
        Snackbar.make(view, "My text", Snackbar.LENGTH_LONG).show();
    }

    /**
     * Sets elements (posts) to recycler view list.
     */
    public void setUpList(List<Post> posts) {
        postsRecView.setHasFixedSize(true);
        postsRecView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        postsRecView.setItemAnimator(new DefaultItemAnimator());
        postsRecView.setAdapter(new PostAdapter(posts, postsRecView));
    }
}
