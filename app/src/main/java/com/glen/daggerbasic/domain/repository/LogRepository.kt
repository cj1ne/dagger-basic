package com.glen.daggerbasic.domain.repository

import com.glen.daggerbasic.domain.entity.Log
import kotlinx.coroutines.flow.Flow

interface LogRepository {
    suspend fun addLog(logs: List<Log>): Result<Unit>
    suspend fun clearLog(): Result<Unit>
    fun getLogFlow(): Flow<List<Log>>
}