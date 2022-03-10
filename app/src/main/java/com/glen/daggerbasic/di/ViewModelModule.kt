package com.glen.daggerbasic.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.glen.daggerbasic.presentation.loghistory.LogHistoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LogHistoryViewModel::class)
    abstract fun bindLogHistoryViewModel(viewModel: LogHistoryViewModel): ViewModel
}