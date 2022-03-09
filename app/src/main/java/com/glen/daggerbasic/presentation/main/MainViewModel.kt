package com.glen.daggerbasic.presentation.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class MainViewModel : ViewModel() {

    sealed class Event {
        object OpenPredictAge : Event()
        object OpenLogHistory : Event()
    }

    private val _event = MutableSharedFlow<Event>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val event: SharedFlow<Event> = _event

    fun onPredictAgeClicked() {
        _event.tryEmit(Event.OpenPredictAge)
    }

    fun onLogHistoryClicked() {
        _event.tryEmit(Event.OpenLogHistory)
    }
}