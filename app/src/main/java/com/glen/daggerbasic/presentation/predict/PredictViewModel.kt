package com.glen.daggerbasic.presentation.predict

import androidx.lifecycle.ViewModel
import com.glen.daggerbasic.presentation.Logger

class PredictViewModel(
    val logger: Logger
) : ViewModel() {

    init {
        logger.addLog("Predict Started")
    }

    override fun onCleared() {
        super.onCleared()
        logger.addLog("Predict Finished")
    }
}