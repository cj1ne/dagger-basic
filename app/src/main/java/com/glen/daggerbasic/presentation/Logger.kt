package com.glen.daggerbasic.presentation

import com.glen.daggerbasic.domain.entity.Log
import com.glen.daggerbasic.domain.usecase.AddLogUseCase
import java.util.*

class Logger(private val addLogUseCase: AddLogUseCase) {

    private val messages = mutableListOf<Log>()

    fun addLog(message: String) {
        messages.add(Log(message = message, date = Calendar.getInstance().timeInMillis))
    }

    suspend fun saveLogs() {
        addLogUseCase(messages)
    }
}