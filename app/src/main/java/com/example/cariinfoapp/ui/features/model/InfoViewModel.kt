package com.example.cariinfoapp.ui.features.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cariinfoapp.data.database.model.Article
import com.example.cariinfoapp.data.network.repository.InfoRepository
import com.example.cariinfoapp.ui.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class InfoViewModel @Inject constructor(
    private val repository: InfoRepository
) : ViewModel() {
    private val _articles = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)
    val articles: StateFlow<UiState<List<Article>>> = _articles

    private val _selectedArticle = MutableStateFlow<Article?>(null)
    val selectedArticle: StateFlow<Article?> = _selectedArticle.asStateFlow()

    private val _fromCache = MutableStateFlow(false)
    val fromCache: StateFlow<Boolean> = _fromCache.asStateFlow()

    fun fetchTopHeadlines() {
        viewModelScope.launch {
            _articles.value = UiState.Loading
            try {
                val (articles, fromcache) = repository.getTopHeadlines()
                _articles.value = UiState.Success(articles)
                _fromCache.value = fromcache
            } catch (e: Exception) {
                _articles.value = UiState.Error(e.localizedMessage ?: "Unknown error")
                _fromCache.value = true
            }
        }
    }


    fun selectArticle(article: Article) {
        _selectedArticle.value = article
    }

    fun clearSelectedArticle() {
        _selectedArticle.value = null
    }
}