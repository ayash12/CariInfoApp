package com.example.cariinfoapp.ui.features.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cariinfoapp.data.database.model.Article
import com.example.cariinfoapp.data.network.repository.InfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class UiState {
    object Loading : UiState()
    data class Success(val articles: List<Article>) : UiState()
    data class Error(val message: String) : UiState()
}

@HiltViewModel
class InfoViewModel @Inject constructor(
    private val repository: InfoRepository
) : ViewModel() {
    private val _articles = MutableStateFlow<UiState>(UiState.Loading)
    val articles: StateFlow<UiState> = _articles.asStateFlow()

    // Shared selection for DetailScreen
    private val _selectedArticle = MutableStateFlow<Article?>(null)
    val selectedArticle: StateFlow<Article?> = _selectedArticle.asStateFlow()

    fun fetchTopHeadlines() {
        viewModelScope.launch {
            _articles.value = UiState.Loading
            try {
                val headlines = repository.getTopHeadlines()
                _articles.value = UiState.Success(headlines)
            }catch (e: Exception) {
                _articles.value = UiState.Error(e.localizedMessage ?: "Unknown error")
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