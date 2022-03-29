package com.example.rma_lv2.data.room

import androidx.room.TypeConverter
import java.util.*

class BirdConverters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }
}