package com.glen.daggerbasic.di

import com.glen.daggerbasic.presentation.loghistory.LogHistoryActivity
import com.glen.daggerbasic.presentation.predict.PredictActivity
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [ViewModelModule::class, AndroidInjectionModule::class])
@InstallIn(SingletonComponent::class)
abstract class AppSubComponents {

    @ActivityScope
    @ContributesAndroidInjector(modules = [PredictModule::class])
    abstract fun predictActivity(): PredictActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [LogHistoryModule::class])
    abstract fun logHistoryActivity(): LogHistoryActivity
}