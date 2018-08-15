package tomaszkopacz.meetbam.view

import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_account.*
import tomaszkopacz.meetbam.R

class AccountActivity : AppCompatActivity() {

    var app : MainApp? = null

    private var mAccountInfoFragment: AccountInfoFragment? = null
    private var mAccountPhotosFragment: AccountPhotosFragment? = null
    private var mAccountFriendsFragment: AccountFriendsFragment? = null

    companion object {

        private const val ACCOUNT_TITLE = "ACCOUNT"
        private const val PHOTOS_TITLE = "PHOTOS"
        private const val FRIENDS_TITLE = "FRIENDS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        setSupportActionBar(account_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        app = application as MainApp

        setUpViewPager(account_viewpager)
        account_tabs.setupWithViewPager(account_viewpager)
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
        mAccountInfoFragment = AccountInfoFragment()
        mAccountPhotosFragment = AccountPhotosFragment()
        mAccountFriendsFragment = AccountFriendsFragment()

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addItem(mAccountInfoFragment!!, ACCOUNT_TITLE)
        adapter.addItem(mAccountPhotosFragment!!, PHOTOS_TITLE)
        adapter.addItem(mAccountFriendsFragment!!, FRIENDS_TITLE)

        viewPager!!.adapter = adapter
    }
}
