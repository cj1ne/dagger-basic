package com.glen.daggerbasic.di

import com.glen.daggerbasic.presentation.loghistory.LogHistoryActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [LogHistoryModule::class])
interface LogHistoryComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): LogHistoryComponent
    }

    fun inject(activity: LogHistoryActivity)
}