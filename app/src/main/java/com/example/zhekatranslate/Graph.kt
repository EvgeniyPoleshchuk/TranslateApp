package com.example.zhekatranslate

import android.content.Context
import androidx.room.Room
import com.example.zhekatranslate.data.TransRepository
import com.example.zhekatranslate.data.TranslateDataBase

object Graph {
    lateinit var dataBase: TranslateDataBase

    val translateRepository by lazy {
        TransRepository(dataBase.translateDao())
    }

    fun provide(context: Context) {
        dataBase =
            Room.databaseBuilder(context, TranslateDataBase::class.java, "TranslateList.db").build()
    }
}