package tomaszkopacz.meetbam.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main_posts.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.MainPostsFragmentPresenter

class MainPostsFragment : Fragment() {

    private lateinit var presenter: MainPostsFragmentPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main_posts, container, false)
        presenter = MainPostsFragmentPresenter(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        main_refresh.setOnRefreshListener {
            presenter.refresh()
            main_refresh.isRefreshing = false
        }

        prepareRecyclerView()
        presenter.downloadPosts()
    }

    private fun prepareRecyclerView() {
        posts_recview.setHasFixedSize(true)
        posts_recview.layoutManager = StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL)
        posts_recview.itemAnimator = DefaultItemAnimator()
    }

    fun putPosts(adapter: PostAdapter) {
        if (posts_recview != null)
            posts_recview.adapter = adapter
    }

    fun refreshDone() {
        if (main_refresh != null)
            main_refresh.isRefreshing = false
    }
}
