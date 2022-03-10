package com.glen.daggerbasic.data.datasource.local

import com.glen.daggerbasic.domain.entity.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface LogLocalDataSource {
    suspend fun addLog(logs: List<Log>): Result<Unit>
    suspend fun clearLog(): Result<Unit>
    fun getLogFlow(): Flow<List<Log>>
}

class LogLocalDataSourceImpl @Inject constructor(
    private val logDao: LogDao
) : LogLocalDataSource {

    override suspend fun addLog(logs: List<Log>): Result<Unit> {
        return Result.runCatching {
            logDao.insert(
                logs.map {
                    LogDTO(
                        message = it.message,
                        date = it.date
                    )
                }
            )
        }
    }

    override suspend fun clearLog(): Result<Unit> {
        return Result.runCatching {
            logDao.deleteAll()
        }
    }

    override fun getLogFlow(): Flow<List<Log>> {
        return logDao.getFlow().map { logs ->
            logs.mapNotNull { it.toEntity() }
        }
    }
}