package com.glen.daggerbasic.data.datasource.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.glen.daggerbasic.data.datasource.local.LogDTO.Companion.TABLE_NAME
import com.glen.daggerbasic.domain.entity.Log
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = TABLE_NAME)
data class LogDTO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_NAME_ID) val id: Int = 0,
    @ColumnInfo(name = COLUMN_NAME_MESSAGE) val message: String,
    @ColumnInfo(name = COLUMN_NAME_DATE) val date: Long
) {
    companion object {
        const val TABLE_NAME = "log"
        const val COLUMN_NAME_ID = "id"
        const val COLUMN_NAME_MESSAGE = "message"
        const val COLUMN_NAME_DATE = "date"
    }
}

internal fun LogDTO.toEntity(): Log? {
    return if (message.isBlank()) {
        null
    } else {
        Log(
            id = id,
            message = message,
            date = SimpleDateFormat("yyyy.MM.dd.", Locale.getDefault()).format(Date(date))
        )
    }
}