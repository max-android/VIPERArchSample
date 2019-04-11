package com.my_project.viperarchsample.di.modules

import com.my_project.viperarchsample.interactor.login.LoginInteractor
import com.my_project.viperarchsample.interactor.main.MainInteractor
import com.my_project.viperarchsample.interactor.sources.SourcesInteractor
import com.my_project.viperarchsample.interactor.users.UsersInteractor
import com.my_project.viperarchsample.model.data_holder.LocalHolder
import com.my_project.viperarchsample.model.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class InteractorModule {

    @Provides
    @Singleton
    fun provideMainInteractor(localHolder: LocalHolder) = MainInteractor(localHolder)

    @Provides
    @Singleton
    fun provideLoginInteractor(apiService: ApiService, localHolder: LocalHolder) =
        LoginInteractor(apiService, localHolder)

    @Provides
    @Singleton
    fun provideUsersInteractor(apiService: ApiService) = UsersInteractor(apiService)

    @Provides
    @Singleton
    fun provideSourceInteractor(apiService: ApiService) = SourcesInteractor(apiService)
}