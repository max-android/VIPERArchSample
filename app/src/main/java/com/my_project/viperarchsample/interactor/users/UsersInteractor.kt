package com.my_project.viperarchsample.interactor.users

import android.util.Log
import com.my_project.viperarchsample.entity.users.WrapUser
import com.my_project.viperarchsample.model.network.ApiService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class UsersInteractor @Inject constructor(private val apiService: ApiService) {

    init {
        Log.d("--LOG-", "UsersInteractor")
    }

    fun users(): Single<List<WrapUser>> {
        return apiService.usersRequest()
            .subscribeOn(Schedulers.io())
            .concatMapIterable {it.user}
            .concatMap { apiService.userRequest(it.id).subscribeOn(Schedulers.computation()) }
            .observeOn(AndroidSchedulers.mainThread())
            .toList()
    }
}