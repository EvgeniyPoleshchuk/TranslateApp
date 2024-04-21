package com.example.zhekatranslate.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "translate-table")
data class Translate(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "origin-text")
    val original: String = "",
    @ColumnInfo(name = "translated-text")
    val translated: String = ""
)
