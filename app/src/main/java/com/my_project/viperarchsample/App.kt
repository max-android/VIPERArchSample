package com.my_project.viperarchsample

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.my_project.viperarchsample.di.*
import com.my_project.viperarchsample.di.modules.InteractorModule
import com.my_project.viperarchsample.di.modules.LocalHolderModule
import com.my_project.viperarchsample.di.modules.RouterModule
import com.my_project.viperarchsample.di.modules.ServiceModule


class App : Application() {

    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .routerModule(RouterModule())
            .interactorModule(InteractorModule())
            .localHolderModule(LocalHolderModule(this))
            .serviceModule(ServiceModule())
            .build()
        initFresco()
    }

    private fun initFresco()= Fresco.initialize(this)

}