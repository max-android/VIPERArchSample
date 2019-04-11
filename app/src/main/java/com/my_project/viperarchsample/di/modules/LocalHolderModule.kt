package com.my_project.viperarchsample.di.modules

import android.content.Context
import com.my_project.viperarchsample.model.data_holder.LocalHolder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalHolderModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideLocalHolder(): LocalHolder {
        return LocalHolder(context)
    }
}