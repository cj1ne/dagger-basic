package com.glen.daggerbasic.di

import com.glen.daggerbasic.presentation.loghistory.LogHistoryActivity
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module(subcomponents = [PredictComponent::class, LogHistoryComponent::class])
abstract class AppSubComponents {

    @Binds
    @IntoMap
    @ClassKey(LogHistoryActivity::class)
    abstract fun bindAndroidInjectorFactory(builder: LogHistoryComponent.Factory?): AndroidInjector.Factory<*>?
}