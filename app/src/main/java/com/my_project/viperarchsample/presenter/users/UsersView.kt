package com.my_project.viperarchsample.presenter.users

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.my_project.viperarchsample.entity.users.WrapUser



@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView: MvpView {
    fun showUsers(users:List<WrapUser>)
    @StateStrategyType(SkipStrategy::class)
    fun showError(message:String)
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showProgress()
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun removeProgress()
}