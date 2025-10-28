package com.example.cariinfoapp.data.network.repository

import com.example.cariinfoapp.data.database.model.Article
import com.example.cariinfoapp.data.network.client.RetrofitClient
import com.example.cariinfoapp.data.network.service.InfoApiService
import javax.inject.Inject

class InfoRepository @Inject constructor(
    private val api: InfoApiService
) {
//    private val api = RetrofitClient.instance.create(InfoApiService::class.java)

    suspend fun getTopHeadlines(): List<Article> {
        return try {
            val response = api.getTopHeadlines()
            if (response.isSuccessful) {
                response.body()?.articles.orEmpty()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}