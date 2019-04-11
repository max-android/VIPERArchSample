package com.my_project.viperarchsample.interactor.main

import android.util.Log
import com.my_project.viperarchsample.model.data_holder.LocalHolder
import javax.inject.Inject


class MainInteractor @Inject constructor(private val localHolder: LocalHolder) {

    init {
        Log.d("--LOG-", "MainInteractor")
    }

    fun token() = localHolder.token()
}