package tomaszkopacz.meetbam.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_stats_global.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.presenter.StatsGlobalFragmentPresenter

class StatsGlobalFragment : Fragment() {

    private lateinit var presenter: StatsGlobalFragmentPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_stats_global, container, false)

        presenter = StatsGlobalFragmentPresenter(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareRecView()
        presenter.downloadResults()
    }

    private fun prepareRecView() {
        stats_global_recview.setHasFixedSize(true)
        stats_global_recview.layoutManager = LinearLayoutManager(activity)
        stats_global_recview.itemAnimator = DefaultItemAnimator()
    }

    fun putResults(adapter: UserAdapter) {
        stats_global_recview.adapter = adapter
    }
}
