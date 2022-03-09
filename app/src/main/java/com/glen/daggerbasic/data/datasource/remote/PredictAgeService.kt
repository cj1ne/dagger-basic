package com.glen.daggerbasic.data.datasource.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface PredictAgeService {

    @GET(".")
    suspend fun getPredictAgeResult(
        @Query("name") name: String
    ): PredictAgeResultDTO
}