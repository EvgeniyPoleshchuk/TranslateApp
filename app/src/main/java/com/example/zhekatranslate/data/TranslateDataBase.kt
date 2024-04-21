package com.example.zhekatranslate.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Translate::class],
    version = 2,
    exportSchema = false
)
abstract class TranslateDataBase:RoomDatabase() {
    abstract fun translateDao():TranslateDao
}