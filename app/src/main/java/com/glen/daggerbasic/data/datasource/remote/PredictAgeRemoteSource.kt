package com.glen.daggerbasic.data.datasource.remote

import com.glen.daggerbasic.domain.entity.PredictAgeResult

interface PredictAgeRemoteSource {
    suspend fun getPredictAgeResult(name: String): Result<PredictAgeResult>
}

class PredictAgeRemoteSourceImpl(
    private val predictAgeService: PredictAgeService
) : PredictAgeRemoteSource {
    override suspend fun getPredictAgeResult(name: String): Result<PredictAgeResult> {
        return Result.runCatching {
            predictAgeService.getPredictAgeResult(name).toEntity()
        }
    }
}