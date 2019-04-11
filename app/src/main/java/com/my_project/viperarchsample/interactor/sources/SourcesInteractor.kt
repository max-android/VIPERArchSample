package com.my_project.viperarchsample.interactor.sources

import android.util.Log
import com.my_project.viperarchsample.entity.sources.WrapSource
import com.my_project.viperarchsample.model.network.ApiService
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class SourcesInteractor @Inject constructor(private val apiService: ApiService) {


    init {
        Log.d("--LOG-", "SourcesInteractor")
    }

    fun sources(): Single<List<WrapSource>> {
        return apiService.sourcesRequest()
            .subscribeOn(Schedulers.io())
            .concatMap { Flowable.range(1, it.source.size) }
            .concatMap { apiService.sourceRequest(it).subscribeOn(Schedulers.computation()) }
            .observeOn(AndroidSchedulers.mainThread())
            .toList()
    }
}