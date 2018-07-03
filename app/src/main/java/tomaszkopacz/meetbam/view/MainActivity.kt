package tomaszkopacz.meetbam.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: MainActivityPresenter
    private lateinit var pagerAdapter: ScreenSliderPagerAdapter

    companion object {
        const val CAMERA_CODE = 1
        private val NUM_PAGES = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)

        presenter = MainActivityPresenter(this)
        pagerAdapter = ScreenSliderPagerAdapter(supportFragmentManager)
        preparePagerView()
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CAMERA_CODE && resultCode == Activity.RESULT_OK) {
            presenter.photoTaken()
        }
    }

    /*==============================================================================================
                                        PAGER VIEW
    ==============================================================================================*/

    private class ScreenSliderPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            when (position){
                0 -> return MainPhotoFragment()
                1 -> return MainPostsFragment()
            }

            return Fragment()
        }

        override fun getCount(): Int {
            return NUM_PAGES
        }

    }

    private fun preparePagerView(){
        main_viewpager.adapter = pagerAdapter
        main_viewpager.currentItem = 1
        main_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> supportActionBar!!.hide()
                    1 -> supportActionBar!!.show()
                }
            }
        })
    }

}
