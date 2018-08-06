package tomaszkopacz.meetbam.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_account_photos.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.AccountPhotosFragmentPresenter

class AccountPhotosFragment : Fragment() {

    private lateinit var presenter: AccountPhotosFragmentPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_account_photos, container, false)

        presenter = AccountPhotosFragmentPresenter(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareRecView()
        presenter.downloadPostsList()
    }

    private fun prepareRecView() {
        user_posts_recview.layoutManager = StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL)
        user_posts_recview.setHasFixedSize(true)
        user_posts_recview.itemAnimator = DefaultItemAnimator()
    }

    fun putPhotos(adapter: PostAdapter) {
        user_posts_recview.adapter = adapter
    }
}
