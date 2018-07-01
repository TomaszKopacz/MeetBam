package tomaszkopacz.meetbam.view

import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_stats.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.service.ViewPagerAdapter

class StatsActivity : AppCompatActivity() {

    private var mStatsLocalFragment = StatsGlobalFragment()
    private var mStatsGlobalFragment = StatsLocalFragment()

    companion object {
        private val LOCAL_RANKING_TITLE = "LOCAL"
        private val GLOBAL_RANKING_TITLE = "GLOBAL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        setSupportActionBar(stats_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        setUpViewPager(stats_viewpager)

        stats_tabs.setupWithViewPager(stats_viewpager)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setUpViewPager(viewPager: ViewPager?) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addItem(mStatsLocalFragment, LOCAL_RANKING_TITLE)
        adapter.addItem(mStatsGlobalFragment, GLOBAL_RANKING_TITLE)

        viewPager!!.adapter = adapter
    }
}
