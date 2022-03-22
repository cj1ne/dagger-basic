package com.glen.daggerbasic.di

import com.glen.daggerbasic.presentation.loghistory.LogHistoryActivity
import com.glen.daggerbasic.presentation.predict.PredictActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppSubComponents {

    @ActivityScope
    @ContributesAndroidInjector(modules = [PredictModule::class])
    abstract fun predictActivity(): PredictActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [LogHistoryModule::class])
    abstract fun logHistoryActivity(): LogHistoryActivity
}