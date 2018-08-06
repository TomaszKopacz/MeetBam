package tomaszkopacz.meetbam.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_stats_local.*
import tomaszkopacz.meetbam.R
import tomaszkopacz.meetbam.interactor.WebService
import tomaszkopacz.meetbam.presenter.StatsLocalFragmentPresenter
import javax.inject.Inject

class StatsLocalFragment : Fragment() {

    private lateinit var presenter: StatsLocalFragmentPresenter

    @Inject internal lateinit var service: WebService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_stats_local, container, false)

        presenter = StatsLocalFragmentPresenter(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareRecyclerView()
        presenter.downloadResults()
    }

    private fun prepareRecyclerView() {
        stats_local_recview.setHasFixedSize(true)
        stats_local_recview.layoutManager = LinearLayoutManager(activity)
        stats_local_recview.itemAnimator = DefaultItemAnimator()
    }

    fun putResults(adapter: UserAdapter) {
        stats_local_recview.adapter = adapter
    }
}
