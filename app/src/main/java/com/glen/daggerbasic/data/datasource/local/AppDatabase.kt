package com.glen.daggerbasic.data.datasource.local

import android.content.Context
import androidx.room.*
import com.glen.daggerbasic.data.datasource.local.AppDatabase.Companion.DATABASE_VERSION
import com.glen.daggerbasic.data.datasource.local.LogDTO.Companion.COLUMN_NAME_DATE
import com.glen.daggerbasic.data.datasource.local.LogDTO.Companion.TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Database(entities = [LogDTO::class], version = DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "dagger-basic.db"
        const val DATABASE_VERSION = 1

        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(AppDatabase::class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                }
                return instance!!
            }
        }
    }

    abstract fun logDao(): LogDao
}

@Dao
interface LogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(log: LogDTO)

    @Query("DELETE FROM $TABLE_NAME")
    suspend fun deleteAll()

    @Query("SELECT * FROM $TABLE_NAME ORDER BY $COLUMN_NAME_DATE DESC")
    fun getFlow(): Flow<List<LogDTO>>
}