package com.glen.daggerbasic.di

import android.content.Context
import com.glen.daggerbasic.presentation.loghistory.LogHistoryActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    RepositoryModule::class,
    DataSourceModule::class,
    LocalModule::class,
    ViewModelModule::class
])
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: LogHistoryActivity)
}