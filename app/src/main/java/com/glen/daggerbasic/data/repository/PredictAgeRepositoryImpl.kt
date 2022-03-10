package com.glen.daggerbasic.data.repository

import com.glen.daggerbasic.data.datasource.remote.PredictAgeRemoteSource
import com.glen.daggerbasic.domain.entity.PredictAgeResult
import com.glen.daggerbasic.domain.repository.PredictAgeRepository
import javax.inject.Inject

class PredictAgeRepositoryImpl @Inject constructor(
    private val predictAgeRemoteSource: PredictAgeRemoteSource
): PredictAgeRepository {

    override suspend fun getPredictAgeResult(name: String): Result<PredictAgeResult> {
        return predictAgeRemoteSource.getPredictAgeResult(name)
    }
}