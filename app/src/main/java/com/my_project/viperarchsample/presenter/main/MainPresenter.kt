package com.my_project.viperarchsample.presenter.main

import android.support.v4.app.FragmentManager
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.my_project.viperarchsample.App
import com.my_project.viperarchsample.interactor.main.MainInteractor
import com.my_project.viperarchsample.router.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    @Inject
    lateinit var mainInteractor: MainInteractor

    @Inject
    lateinit var router: Router

    init {
        App.appComponent.injectMainPresenter(this)
    }

    fun token() = mainInteractor.token()

    fun showScreen(fragmentManager: FragmentManager, screen: String) {
        router.createFragment(fragmentManager, screen)
    }
}