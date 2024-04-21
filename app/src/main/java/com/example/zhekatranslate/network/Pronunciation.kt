package com.example.zhekatranslate.network


import com.google.gson.annotations.SerializedName

data class Pronunciation(
    @SerializedName("destination-text-audio")
    val destinationTextAudio: String,
    @SerializedName("source-text-audio")
    val sourceTextAudio: String,
    @SerializedName("source-text-phonetic")
    val sourceTextPhonetic: String
)