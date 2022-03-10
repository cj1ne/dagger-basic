package com.glen.daggerbasic.domain.usecase

import com.glen.daggerbasic.domain.repository.LogRepository
import javax.inject.Inject

class ClearLogUseCase @Inject constructor(
    private val repository: LogRepository
) {
    suspend operator fun invoke(): Result<Unit> {
        return repository.clearLog()
    }
}