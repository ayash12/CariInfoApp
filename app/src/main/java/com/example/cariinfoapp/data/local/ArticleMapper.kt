package com.example.cariinfoapp.data.local

import com.example.cariinfoapp.data.database.model.Article

fun Article.toEntity(): InfoEntity = InfoEntity(
    title = this.title ?: "",
    description = this.description,
    url = this.url,
    urlToImage = this.urlToImage,
    author = this.author,
    publishedAt = this.publishedAt
)

fun InfoEntity.toModel(): Article = Article(
    author = this.author,
    title = this.title,
    description = this.description,
    url = this.url,
    urlToImage = this.urlToImage,
    publishedAt = this.publishedAt
)