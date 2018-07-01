package tomaszkopacz.meetbam.view

import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_account.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.service.LoginService
import tomaszkopacz.meetbam.service.ViewPagerAdapter

class AccountActivity : AppCompatActivity() {

    private var mAccountInfoFragment: AccountInfoFragment? = null
    private var mAccountPhotosFragment: AccountPhotosFragment? = null
    private var mAccountFriendsFragment: AccountFriendsFragment? = null

    companion object {

        private val ACCOUNT_TITLE = "ACCOUNT"
        private val PHOTOS_TITLE = "PHOTOS"
        private val FRIENDS_TITLE = "FRIENDS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        setSupportActionBar(account_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        setTitle()
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

    private fun setTitle() {
        val service = LoginService(applicationContext)
        val loggedUser = service.getLoggedUser()
        title = getString(R.string.paired_user, loggedUser.name, loggedUser.surname)
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
