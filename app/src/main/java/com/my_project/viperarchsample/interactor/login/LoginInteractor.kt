package com.my_project.viperarchsample.interactor.login

import android.annotation.SuppressLint
import com.my_project.viperarchsample.entity.login.TokenResponse
import com.my_project.viperarchsample.model.data_holder.LocalHolder
import com.my_project.viperarchsample.model.network.ApiService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class LoginInteractor @Inject constructor(private val apiService: ApiService, private val localHolder: LocalHolder) {

    @SuppressLint("CheckResult")
    fun login(mail: String, password: String): Single<TokenResponse> {
        return apiService
            .loginRequest(mail, password)
            .doOnSuccess { localHolder.setToken(it.token) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}