package com.glen.daggerbasic.di

import android.content.Context
import com.glen.daggerbasic.presentation.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    RepositoryModule::class,
    DataSourceModule::class,
    LocalModule::class,
    RemoteModule::class,
    ViewModelModule::class,
    AppSubComponents::class,
    AndroidInjectionModule::class
])
interface AppComponent : AndroidInjector<MyApplication> {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    // Type that can be retrieved from the graph
    fun predictComponent(): PredictComponent.Factory
}