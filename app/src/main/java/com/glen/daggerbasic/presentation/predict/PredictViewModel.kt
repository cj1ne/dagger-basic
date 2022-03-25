package com.glen.daggerbasic.presentation.predict

import androidx.lifecycle.ViewModel
import com.glen.daggerbasic.presentation.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PredictViewModel @Inject constructor(
    private val logger: Logger
) : ViewModel() {

    init {
        logger.addLog("Predict Started")
    }

    override fun onCleared() {
        super.onCleared()
        logger.addLog("Predict Finished")
    }
}