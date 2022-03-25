package com.glen.daggerbasic.presentation

import com.glen.daggerbasic.domain.entity.Log
import com.glen.daggerbasic.domain.usecase.AddLogUseCase
import dagger.hilt.android.scopes.ActivityRetainedScoped
import java.util.*
import javax.inject.Inject

@ActivityRetainedScoped
class Logger @Inject constructor(private val addLogUseCase: AddLogUseCase) {

    private val messages = mutableListOf<Log>()

    fun addLog(message: String) {
        messages.add(Log(message = message, date = Calendar.getInstance().timeInMillis))
    }

    suspend fun saveLogs() {
        addLogUseCase(messages)
    }
}