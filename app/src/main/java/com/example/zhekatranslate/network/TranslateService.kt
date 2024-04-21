package com.example.zhekatranslate.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslateService {
    @GET( "translate?sl=en&dl=tr&text=example")
    suspend fun getTranslate(@Query("sl") sl:String,
                             @Query("dl") dl:String,
                             @Query("text") text:String):Data

}
var retrofit = Retrofit.Builder()
    .baseUrl("https://ftapi.pythonanywhere.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var translateService = retrofit.create(TranslateService::class.java)
