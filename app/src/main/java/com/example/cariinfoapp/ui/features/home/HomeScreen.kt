package com.example.cariinfoapp.ui.features.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cariinfoapp.ui.features.model.InfoViewModel
import com.example.cariinfoapp.ui.state.UiState

@Composable
fun HomeScreen(viewModel: InfoViewModel = hiltViewModel()) {
    val articles by viewModel.articles.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchTopHeadlines()
    }
    when(articles){
        is UiState.Loading -> LoadingView()
        is UiState.Success -> ArticleList((articles as UiState.Success).data)
        is UiState.Error -> ErrorView((articles as UiState.Error).message)
    }
}

@Composable
fun LoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorView(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Error: $message", color = MaterialTheme.colorScheme.error)
    }
}

@Composable
fun ArticleList(articles: List<com.example.cariinfoapp.data.database.model.Article>) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp)
    ) {
        items(articles) { article ->
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = article.title ?: "No title",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = article.description ?: "",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}