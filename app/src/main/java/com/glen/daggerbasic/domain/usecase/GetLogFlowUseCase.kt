package com.glen.daggerbasic.domain.usecase

import com.glen.daggerbasic.domain.entity.Log
import com.glen.daggerbasic.domain.repository.LogRepository
import kotlinx.coroutines.flow.Flow

class GetLogFlowUseCase(
    private val repository: LogRepository
) {
    operator fun invoke(): Flow<List<Log>> {
        return repository.getLogFlow()
    }
}