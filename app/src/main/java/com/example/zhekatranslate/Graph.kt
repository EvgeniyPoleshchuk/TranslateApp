package com.example.zhekatranslate

import android.content.Context
import androidx.room.Room
import com.example.mywishlist.data.WishDataBase
import com.example.mywishlist.data.WishRepository
//import com.example.zhekatranslate.data.TransRepository
//import com.example.zhekatranslate.data.TranslateDataBase

object Graph {

    lateinit var dataBase: WishDataBase

    val wishRepository by lazy {
        WishRepository(dataBase.wishDao())
    }
    fun provide(context: Context){
        dataBase = Room.databaseBuilder(context, WishDataBase::class.java,"wishList.db").build()
    }
}