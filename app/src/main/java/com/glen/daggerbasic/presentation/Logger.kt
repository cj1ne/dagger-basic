package com.glen.daggerbasic.presentation

import com.glen.daggerbasic.domain.entity.Log
import com.glen.daggerbasic.domain.usecase.AddLogUseCase
import java.util.*
import javax.inject.Inject

class Logger @Inject constructor(private val addLogUseCase: AddLogUseCase) {

    private val messages = mutableListOf<Log>()

    fun addLog(message: String) {
        messages.add(Log(message = message, date = Calendar.getInstance().timeInMillis))
    }

    suspend fun saveLogs() {
        addLogUseCase(messages)
    }
}