package com.example.cariinfoapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "info_table")
data class InfoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val author: String?,
    val publishedAt: String?
)