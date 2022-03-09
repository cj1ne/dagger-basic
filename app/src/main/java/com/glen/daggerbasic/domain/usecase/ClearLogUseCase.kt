package com.glen.daggerbasic.domain.usecase

import com.glen.daggerbasic.domain.repository.LogRepository

class ClearLogUseCase(
    private val repository: LogRepository
) {
    suspend operator fun invoke(): Result<Unit> {
        return repository.clearLog()
    }
}