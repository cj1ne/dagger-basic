package com.glen.daggerbasic.di

import android.content.Context
import androidx.room.Room
import com.glen.daggerbasic.data.datasource.local.AppDatabase
import com.glen.daggerbasic.data.datasource.local.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideLogDao(database: AppDatabase): LogDao = database.logDao()
}