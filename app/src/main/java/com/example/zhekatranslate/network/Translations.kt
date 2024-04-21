package com.example.zhekatranslate.network


import com.google.gson.annotations.SerializedName

data class Translations(
    @SerializedName("all-translations")
    val allTranslations: List<List<Any>>,
    @SerializedName("possible-mistakes")
    val possibleMistakes: Any?,
    @SerializedName("possible-translations")
    val possibleTranslations: List<String>
)