package com.my_project.viperarchsample.presenter.sources

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.my_project.viperarchsample.entity.sources.WrapSource


@StateStrategyType(AddToEndSingleStrategy::class)
interface SourcesView:MvpView {
    fun showSources(sources:List<WrapSource>)
    @StateStrategyType(SkipStrategy::class)
    fun showError(message:String)
    @StateStrategyType(SkipStrategy::class)
    fun showProgress()
    @StateStrategyType(SkipStrategy::class)
    fun removeProgress()
}