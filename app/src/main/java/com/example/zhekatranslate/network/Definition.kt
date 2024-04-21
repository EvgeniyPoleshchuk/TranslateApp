package com.example.zhekatranslate.network


import com.google.gson.annotations.SerializedName

data class Definition(
    @SerializedName("definition")
    val definition: String,
    @SerializedName("example")
    val example: String,
    @SerializedName("other-examples")
    val otherExamples: List<String>?,
    @SerializedName("part-of-speech")
    val partOfSpeech: String,
    @SerializedName("synonyms")
    val synonyms: Synonyms?
)