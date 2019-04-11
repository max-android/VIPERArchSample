package com.my_project.viperarchsample.presenter.sources

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.my_project.viperarchsample.App
import com.my_project.viperarchsample.interactor.sources.SourcesInteractor
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


@InjectViewState
class SourcePresenter: MvpPresenter<SourcesView>() {

    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var sourceInteractor: SourcesInteractor

    init {
        App.appComponent.injectSourcePresenter(this)
    }

    @SuppressLint("CheckResult")
    fun sources(){
        sourceInteractor
            .sources()
            .doOnSubscribe {viewState.showProgress()  }
            .doFinally { viewState.removeProgress() }
            .subscribe(
                { viewState.showSources(it) },
                { error -> viewState.showError(error?.message ?: "null") }
            )
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}