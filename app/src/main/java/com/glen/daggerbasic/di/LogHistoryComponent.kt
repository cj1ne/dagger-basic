package com.glen.daggerbasic.di

import com.glen.daggerbasic.presentation.loghistory.LogHistoryActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = [LogHistoryModule::class])
interface LogHistoryComponent : AndroidInjector<LogHistoryActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<LogHistoryActivity>
}