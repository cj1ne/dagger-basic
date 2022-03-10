package com.glen.daggerbasic.di

import com.glen.daggerbasic.presentation.predict.PredictActivity
import com.glen.daggerbasic.presentation.predict.PredictAgeFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [PredictModule::class])
interface PredictComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): PredictComponent
    }

    fun inject(activity: PredictActivity)
    fun inject(fragment: PredictAgeFragment)
}