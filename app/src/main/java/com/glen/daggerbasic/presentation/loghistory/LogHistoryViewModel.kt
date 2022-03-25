package com.glen.daggerbasic.presentation.loghistory

import androidx.lifecycle.*
import com.glen.daggerbasic.domain.entity.Log
import com.glen.daggerbasic.domain.usecase.ClearLogUseCase
import com.glen.daggerbasic.domain.usecase.GetLogFlowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogHistoryViewModel @Inject constructor(
    private val getLogFlowUseCase: GetLogFlowUseCase,
    private val clearLogUseCase: ClearLogUseCase
) : ViewModel() {

    private val _logs = MutableSharedFlow<List<Log>>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val logs: LiveData<List<Log>> = _logs.asLiveData()

    private val _showEmptyMessage = MutableLiveData(false)
    val showEmptyMessage: LiveData<Boolean> = _showEmptyMessage.distinctUntilChanged()


    init {
        viewModelScope.launch {
            getLogFlowUseCase().collect { logs ->
                _logs.tryEmit(logs)
                _showEmptyMessage.value = logs.isEmpty()
            }
        }
    }


    fun onClearLogClicked() {
        viewModelScope.launch {
            clearLogUseCase()
        }
    }
}