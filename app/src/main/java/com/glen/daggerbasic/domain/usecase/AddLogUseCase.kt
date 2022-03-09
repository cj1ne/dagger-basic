package com.glen.daggerbasic.domain.usecase

import com.glen.daggerbasic.domain.repository.LogRepository

class AddLogUseCase(
    private val repository: LogRepository
) {
    suspend operator fun invoke(message: String): Result<Unit> {
        return repository.addLog(message)
    }
}