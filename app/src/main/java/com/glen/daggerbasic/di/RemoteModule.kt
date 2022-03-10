package com.glen.daggerbasic.di

import com.glen.daggerbasic.data.datasource.remote.PredictAgeService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun providePredictAgeService(): PredictAgeService = Retrofit.Builder()
        .baseUrl("https://api.agify.io/")
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PredictAgeService::class.java)
}