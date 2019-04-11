package com.my_project.viperarchsample.presenter.users

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.my_project.viperarchsample.App
import com.my_project.viperarchsample.interactor.users.UsersInteractor
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


@InjectViewState
class UsersPresenter : MvpPresenter<UsersView>() {

    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var usersInteractor: UsersInteractor

    init {
        App.appComponent.injectUsersPresenter(this)
    }


    @SuppressLint("CheckResult")
    fun users() {
        compositeDisposable.add(
            usersInteractor
                .users()
                .doOnSubscribe { viewState.showProgress() }
                .doFinally { viewState.removeProgress() }
                .subscribe(
                    {
                        viewState.showUsers(it)

                    },
                    { error ->
                        run {
                            viewState.showError(error?.message ?: "null")
                        }
                    }
                )
        )
    }


    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}