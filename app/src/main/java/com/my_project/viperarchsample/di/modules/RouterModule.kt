package com.my_project.viperarchsample.di.modules

import com.my_project.viperarchsample.router.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RouterModule {

    @Provides
    @Singleton
    fun provideRouter(): Router = Router()
}