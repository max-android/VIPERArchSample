package com.my_project.viperarchsample.view.main

import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.my_project.viperarchsample.R
import com.my_project.viperarchsample.presenter.main.MainPresenter
import com.my_project.viperarchsample.presenter.main.MainView
import com.my_project.viperarchsample.router.Screens
import com.my_project.viperarchsample.view.common.CONST

class MainActivity : MvpAppCompatActivity(), MainView {

    private val fragmentManager: FragmentManager = supportFragmentManager

    @JvmField
    @InjectPresenter
    var mPresenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) openScreen()
    }

    @ProvidePresenter
    fun provideMainPresenter(): MainPresenter = MainPresenter()

    private fun openScreen() {
        if (mPresenter?.token() == CONST.DEFAULT_TOKEN) mPresenter?.showScreen(fragmentManager, Screens.LOGIN_FRAGMENT)
        else mPresenter?.showScreen(fragmentManager, Screens.USERS_FRAGMENT)
    }

    fun showUsers() {
        mPresenter?.showScreen(fragmentManager, Screens.USERS_FRAGMENT)
    }

    fun showSources() {
        mPresenter?.showScreen(fragmentManager, Screens.SOURCES_FRAGMENT)
    }
}
