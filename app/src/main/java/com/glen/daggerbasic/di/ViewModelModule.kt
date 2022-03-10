package com.glen.daggerbasic.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.glen.daggerbasic.presentation.loghistory.LogHistoryViewModel
import com.glen.daggerbasic.presentation.predict.PredictAgeViewModel
import com.glen.daggerbasic.presentation.predict.PredictViewModel
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

    @Binds
    @IntoMap
    @ViewModelKey(PredictViewModel::class)
    abstract fun bindPredictViewModel(viewModel: PredictViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PredictAgeViewModel::class)
    abstract fun bindPredictAgeViewModel(viewModel: PredictAgeViewModel): ViewModel
}