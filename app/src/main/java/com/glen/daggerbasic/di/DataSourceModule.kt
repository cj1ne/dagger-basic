package com.glen.daggerbasic.di

import com.glen.daggerbasic.data.datasource.local.LogLocalDataSource
import com.glen.daggerbasic.data.datasource.local.LogLocalDataSourceImpl
import com.glen.daggerbasic.data.datasource.remote.PredictAgeRemoteSource
import com.glen.daggerbasic.data.datasource.remote.PredictAgeRemoteSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindLogLocalDataSource(dataSource: LogLocalDataSourceImpl): LogLocalDataSource

    @Binds
    abstract fun bindPredictAgeRemoteSource(dataSource: PredictAgeRemoteSourceImpl): PredictAgeRemoteSource
}