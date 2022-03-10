package com.glen.daggerbasic.di

import androidx.lifecycle.ViewModel
import com.glen.daggerbasic.presentation.loghistory.LogHistoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LogHistoryModule {

    @Binds
    @IntoMap
    @ViewModelKey(LogHistoryViewModel::class)
    abstract fun bindLogHistoryViewModel(viewModel: LogHistoryViewModel): ViewModel
}