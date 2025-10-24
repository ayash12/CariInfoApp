package com.example.cariinfoapp.ui.features.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cariinfoapp.data.database.model.Article
import com.example.cariinfoapp.data.network.repository.InfoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class InfoViewModel : ViewModel(){
    private val repository = InfoRepository()

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> = _articles

    fun fetchTopHeadlines() {
        viewModelScope.launch {
            _articles.value = repository.getTopHeadlines()
        }
    }
}