package com.example.cariinfoapp.data.network.repository

import com.example.cariinfoapp.data.database.model.Article
import com.example.cariinfoapp.data.local.InfoDAO
import com.example.cariinfoapp.data.local.toEntity
import com.example.cariinfoapp.data.local.toModel
import com.example.cariinfoapp.data.network.client.RetrofitClient
import com.example.cariinfoapp.data.network.service.InfoApiService
import javax.inject.Inject

class InfoRepository @Inject constructor(
    private val api: InfoApiService,
    private val dao: InfoDAO
) {


    suspend fun getTopHeadlines(): Pair<List<Article>, Boolean> {
        return try {
            val response = api.getTopHeadlines()
            if (response.isSuccessful) {
                val articles = response.body()?.articles.orEmpty()
                dao.clearNews()
                dao.insertAll(articles.map { it.toEntity() })
                Pair(articles, false) // false = data dari network
            } else {
                Pair(dao.getAllNews().map { it.toModel() }, true) // true = data cache
            }
        } catch (e: Exception) {
            Pair(dao.getAllNews().map { it.toModel() }, true)
        }
    }
}