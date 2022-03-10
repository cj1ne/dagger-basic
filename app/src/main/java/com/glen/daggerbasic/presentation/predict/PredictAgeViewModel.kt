package com.glen.daggerbasic.presentation.predict

import androidx.lifecycle.*
import com.glen.daggerbasic.domain.usecase.GetPredictAgeUseCase
import com.glen.daggerbasic.presentation.Logger
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PredictAgeViewModel @Inject constructor(
    private val getPredictAgeUseCase: GetPredictAgeUseCase,
    private val logger: Logger
) : ViewModel() {

    sealed class Event {
        data class ShowToast(val message: String) : Event()
    }

    private val _event = MutableSharedFlow<Event>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val event: SharedFlow<Event> = _event

    val name = MutableLiveData("")

    private val _age = MutableLiveData("")
    val age: LiveData<String> = _age.distinctUntilChanged()


    fun onPredictClicked() {
        logger.addLog("Age predict is started for name [${name.value.orEmpty()}]")
        viewModelScope.launch {
            getPredictAgeUseCase(name.value.orEmpty())
                .onSuccess { result ->
                    _age.value = result.age.toString()
                    logger.addLog("Age predict success [${result.age}]")
                }
                .onFailure {
                    _age.value = ""
                    _event.tryEmit(Event.ShowToast("Age prediction failed"))
                    logger.addLog("Age predict failed")
                }
        }
    }

    fun onSaveLogClicked() {
        viewModelScope.launch {
            logger.saveLogs()
            _event.tryEmit(Event.ShowToast("Save log success"))
        }
    }
}