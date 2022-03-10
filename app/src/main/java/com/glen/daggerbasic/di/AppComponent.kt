package com.glen.daggerbasic.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    RepositoryModule::class,
    DataSourceModule::class,
    LocalModule::class,
    RemoteModule::class,
    ViewModelModule::class,
    AppSubComponents::class
])
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    // Type that can be retrieved from the graph
    fun predictComponent(): PredictComponent.Factory
    fun logHistoryComponent(): LogHistoryComponent.Factory
}