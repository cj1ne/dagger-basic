package com.glen.daggerbasic.di

import com.glen.daggerbasic.data.repository.LogRepositoryImpl
import com.glen.daggerbasic.domain.repository.LogRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindLogRepository(repository: LogRepositoryImpl): LogRepository
}