package com.example.rma_lv2.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.rma_lv2.data.BirdsDAO
import model.Bird

@Database(
    entities = [Bird::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(BirdConverters::class)
abstract class BirdsDatabase : RoomDatabase() {

    abstract fun getBirdsDao(): BirdsDAO

    companion object {

        private const val databaseName = "birds_database"

        @Volatile
        private var INSTANCE: BirdsDatabase? = null

        fun getDatabase(context: Context): BirdsDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): BirdsDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                BirdsDatabase::class.java,
                databaseName
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}