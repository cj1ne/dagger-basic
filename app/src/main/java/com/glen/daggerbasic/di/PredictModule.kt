package com.glen.daggerbasic.di

import androidx.lifecycle.ViewModel
import com.glen.daggerbasic.presentation.predict.PredictAgeViewModel
import com.glen.daggerbasic.presentation.predict.PredictViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PredictModule {

    @Binds
    @IntoMap
    @ViewModelKey(PredictViewModel::class)
    abstract fun bindPredictViewModel(viewModel: PredictViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PredictAgeViewModel::class)
    abstract fun bindPredictAgeViewModel(viewModel: PredictAgeViewModel): ViewModel
}