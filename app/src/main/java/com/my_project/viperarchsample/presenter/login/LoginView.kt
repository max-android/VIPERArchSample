package com.my_project.viperarchsample.presenter.login

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface LoginView:MvpView {
    fun showSuccess()
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(message:String)
}