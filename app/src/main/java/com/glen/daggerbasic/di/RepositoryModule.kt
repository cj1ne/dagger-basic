package com.glen.daggerbasic.di

import com.glen.daggerbasic.data.repository.LogRepositoryImpl
import com.glen.daggerbasic.data.repository.PredictAgeRepositoryImpl
import com.glen.daggerbasic.domain.repository.LogRepository
import com.glen.daggerbasic.domain.repository.PredictAgeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindLogRepository(repository: LogRepositoryImpl): LogRepository

    @Binds
    abstract fun bindPredictAgeRepository(repository: PredictAgeRepositoryImpl): PredictAgeRepository
}