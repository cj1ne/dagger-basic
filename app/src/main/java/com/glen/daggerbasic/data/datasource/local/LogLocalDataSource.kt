package com.glen.daggerbasic.data.datasource.local

import com.glen.daggerbasic.domain.entity.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*

interface LogLocalDataSource {
    suspend fun addLog(message: String): Result<Unit>
    suspend fun clearLog(): Result<Unit>
    fun getLogFlow(): Flow<List<Log>>
}

class LogLocalDataSourceImpl(
    private val logDao: LogDao
) : LogLocalDataSource {

    override suspend fun addLog(message: String): Result<Unit> {
        return Result.runCatching {
            logDao.insert(
                LogDTO(
                    message = message,
                    date = Calendar.getInstance().timeInMillis
                )
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