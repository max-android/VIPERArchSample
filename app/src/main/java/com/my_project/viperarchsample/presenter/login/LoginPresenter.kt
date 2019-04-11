package com.my_project.viperarchsample.presenter.login

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.my_project.viperarchsample.App
import com.my_project.viperarchsample.interactor.login.LoginInteractor
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {

    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var loginInteractor: LoginInteractor

    init {
        App.appComponent.injectLoginPresenter(this)
    }

    @SuppressLint("CheckResult")
    fun login(mail: String, password: String, action: () -> Unit) {
        compositeDisposable.add(
            loginInteractor.login(mail, password)
                .doAfterTerminate { action() }
                .subscribe(
                    { viewState.showSuccess() },
                    { error -> viewState.showError(error?.message ?: "null") }
                )

        )

    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}