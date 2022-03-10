package com.glen.daggerbasic.data.repository

import com.glen.daggerbasic.data.datasource.local.LogLocalDataSource
import com.glen.daggerbasic.domain.entity.Log
import com.glen.daggerbasic.domain.repository.LogRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LogRepositoryImpl @Inject constructor(
    private val logLocalDataSource: LogLocalDataSource
) : LogRepository {

    override suspend fun addLog(logs: List<Log>): Result<Unit> {
        return logLocalDataSource.addLog(logs)
    }

    override suspend fun clearLog(): Result<Unit> {
        return logLocalDataSource.clearLog()
    }

    override fun getLogFlow(): Flow<List<Log>> {
        return logLocalDataSource.getLogFlow()
    }
}