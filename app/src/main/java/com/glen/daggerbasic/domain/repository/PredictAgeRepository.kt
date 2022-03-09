package com.glen.daggerbasic.domain.repository

import com.glen.daggerbasic.domain.entity.PredictAgeResult

interface PredictAgeRepository {
    suspend fun getPredictAgeResult(name: String): Result<PredictAgeResult>
}