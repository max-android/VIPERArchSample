package com.my_project.viperarchsample.view.sources

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.my_project.viperarchsample.R
import com.my_project.viperarchsample.entity.sources.WrapSource
import com.my_project.viperarchsample.presenter.sources.SourcePresenter
import com.my_project.viperarchsample.presenter.sources.SourcesView
import kotlinx.android.synthetic.main.sources_fragment.*
import org.jetbrains.anko.support.v4.longToast


class SourcesFragment : MvpAppCompatFragment(), SourcesView {

    companion object {
        fun newInstance(): SourcesFragment {
            return SourcesFragment()
        }
    }

    @JvmField
    @InjectPresenter
    var presenter: SourcePresenter? = null
    private lateinit var sourceAdapter: SourceAdapter

    @ProvidePresenter
    fun provideSourcePresenter(): SourcePresenter = SourcePresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.sources_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
        if (savedInstanceState == null)
            presenter?.sources()
    }

    override fun showSources(sources: List<WrapSource>) {
        sourceAdapter.setData(sources)
    }

    override fun showError(message: String) {
        longToast(message)
    }

    override fun showProgress() {
        sourcesProgressBar.visibility = View.VISIBLE
    }

    override fun removeProgress() {
        sourcesProgressBar.visibility = View.GONE
    }

    private fun initViews() {
        sourceAdapter = SourceAdapter { longToast("select:" + it.sourc.name) }
        sourcesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@SourcesFragment.context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(this@SourcesFragment.context, LinearLayout.VERTICAL))
            adapter = sourceAdapter
        }
    }
}