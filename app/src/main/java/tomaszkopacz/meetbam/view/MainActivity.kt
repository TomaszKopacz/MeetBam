package tomaszkopacz.meetbam.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.MainActivityPresenter
import tomaszkopacz.meetbam.service.PostAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: MainActivityPresenter

    companion object {
        const val CAMERA_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)

        presenter = MainActivityPresenter(this)

        prepareRecyclerView()
        presenter.downloadPosts()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.action_user -> {
                val userIntent = Intent(this, AccountActivity::class.java)
                startActivity(userIntent)
            }

            R.id.action_stats -> {
                val statsIntent = Intent(this, StatsActivity::class.java)
                startActivity(statsIntent)
            }

            R.id.action_map -> {
                val mapIntent = Intent(this, MapActivity::class.java)
                startActivity(mapIntent)
            }

            R.id.action_search -> {
                val searchIntent = Intent(this, SearchActivity::class.java)
                startActivity(searchIntent)
            }

            R.id.action_logout -> presenter.logout()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun prepareRecyclerView() {
        posts_recview.setHasFixedSize(true)
        posts_recview.layoutManager = StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL)
        posts_recview.itemAnimator = DefaultItemAnimator()
    }

    fun putPosts(adapter: PostAdapter) {
        posts_recview.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CAMERA_CODE && resultCode == Activity.RESULT_OK) {
            presenter.photoTaken()
        }
    }
}
