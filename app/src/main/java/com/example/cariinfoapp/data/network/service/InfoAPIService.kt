package com.example.cariinfoapp.data.network.service

import com.example.cariinfoapp.data.network.response.InfoResponse
import com.example.cariinfoapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface InfoApiService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): Response<InfoResponse>
}