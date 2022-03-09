package com.glen.daggerbasic.domain.usecase

import com.glen.daggerbasic.domain.entity.PredictAgeResult
import com.glen.daggerbasic.domain.repository.PredictAgeRepository

class GetPredictAgeUseCase(
    private val repository: PredictAgeRepository
) {
    suspend operator fun invoke(name: String): Result<PredictAgeResult> {
        return repository.getPredictAgeResult(name)
    }
}