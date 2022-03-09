package com.glen.daggerbasic.domain.usecase

import com.glen.daggerbasic.domain.entity.Log
import com.glen.daggerbasic.domain.repository.LogRepository

class AddLogUseCase(
    private val repository: LogRepository
) {
    suspend operator fun invoke(logs: List<Log>): Result<Unit> {
        return repository.addLog(logs)
    }
}