package com.glen.daggerbasic.di

import com.glen.daggerbasic.presentation.loghistory.LogHistoryActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [PredictComponent::class])
abstract class AppSubComponents {

    @ActivityScope
    @ContributesAndroidInjector(modules = [LogHistoryModule::class])
    abstract fun logHistoryActivity(): LogHistoryActivity
}