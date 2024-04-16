package com.example.zhekatranslate.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

//@Dao
//abstract class TranslateDao {
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    abstract suspend fun addTranslate(translateEntity: Translate)
//
//    @Delete
//    abstract suspend fun deleteTranslate(translateEntity: Translate)
//
//    @Query("Select * from `translate-table`")
//    abstract fun getAllTranslate(): Flow<List<Translate>>
//
//
//}