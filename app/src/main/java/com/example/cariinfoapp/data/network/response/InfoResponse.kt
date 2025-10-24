package com.example.cariinfoapp.data.network.response

import com.example.cariinfoapp.data.database.model.Article

data class InfoResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
