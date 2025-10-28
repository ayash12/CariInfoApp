package com.example.cariinfoapp.ui.features.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cariinfoapp.data.database.model.Article
import com.example.cariinfoapp.data.network.repository.InfoRepository
import com.example.cariinfoapp.ui.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    private val repository: InfoRepository
) : ViewModel() {


    private val _articles = MutableStateFlow< UiState<List<Article>>>(UiState.Loading)
    val articles: StateFlow<UiState<List<Article>>> = _articles

    fun fetchTopHeadlines() {
        viewModelScope.launch {
            _articles.value = UiState.Loading
            try {
                val headlines = repository.getTopHeadlines()
                _articles.value = UiState.Success(headlines)
            }catch (e: Exception) {
                _articles.value = UiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}