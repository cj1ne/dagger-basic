package com.glen.daggerbasic.data.datasource.remote

import com.glen.daggerbasic.domain.entity.PredictAgeResult

data class PredictAgeResultDTO(
    val name: String?,
    val age: Int?,
    val count: Int?
)

internal fun PredictAgeResultDTO.toEntity(): PredictAgeResult {
    return PredictAgeResult(
        name = name.orEmpty(),
        age = age ?: 0,
        count = count ?: 0
    )
}