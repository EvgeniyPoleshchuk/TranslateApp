package com.example.zhekatranslate.network


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("definitions")
    val definitions: List<Definition>,
    @SerializedName("destination-language")
    val destinationLanguage: String,
    @SerializedName("destination-text")
    val destinationText: String, // переведенный
    @SerializedName("pronunciation")
    val pronunciation: Pronunciation,
    @SerializedName("see-also")
    val seeAlso: Any?,
    @SerializedName("source-language")
    val sourceLanguage: String,
    @SerializedName("source-text")
    val sourceText: String,
    @SerializedName("translations")
    val translations: Translations
)