package tomaszkopacz.meetbam.view

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.util.*

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments = ArrayList<Fragment>()
    private val titles = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    fun addItem(fragment: Fragment, title: String) {
        fragments.add(fragment)
        titles.add(title)
    }
}
