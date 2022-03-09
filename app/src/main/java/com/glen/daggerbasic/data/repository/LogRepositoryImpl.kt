package com.glen.daggerbasic.data.repository

import com.glen.daggerbasic.data.datasource.local.LogLocalDataSource
import com.glen.daggerbasic.domain.entity.Log
import com.glen.daggerbasic.domain.repository.LogRepository
import kotlinx.coroutines.flow.Flow

class LogRepositoryImpl(
    private val logLocalDataSource: LogLocalDataSource
) : LogRepository {

    override suspend fun addLog(message: String): Result<Unit> {
        return logLocalDataSource.addLog(message)
    }

    override suspend fun clearLog(): Result<Unit> {
        return logLocalDataSource.clearLog()
    }

    override fun getLogFlow(): Flow<List<Log>> {
        return logLocalDataSource.getLogFlow()
    }
}