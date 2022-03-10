package com.glen.daggerbasic.di

import android.content.Context
import androidx.room.Room
import com.glen.daggerbasic.data.datasource.local.AppDatabase
import com.glen.daggerbasic.data.datasource.local.LogDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalModule {

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideLogDao(database: AppDatabase): LogDao = database.logDao()
}