package com.glen.daggerbasic.data.datasource.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun providePredictAgeService(): PredictAgeService = Retrofit.Builder()
    .baseUrl("https://api.agify.io/")
    .client(OkHttpClient.Builder().build())
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(PredictAgeService::class.java)