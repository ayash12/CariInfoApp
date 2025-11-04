package com.example.cariinfoapp.ui.features.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cariinfoapp.data.database.model.Article
import com.example.cariinfoapp.ui.features.home.components.ArticleCard
import com.example.cariinfoapp.ui.state.UiState

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    state: UiState<List<Article>>,
    onArticleClick: (Article) -> Unit,
    onRetry: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is UiState.Loading -> LoadingArticleList()

            is UiState.Success -> {
                if (state.data.isEmpty()) EmptyView()
                else ArticleList(state.data, onArticleClick)
            }
            is UiState.Error -> ErrorView(state.message, onRetry)
        }
    }
}

@Composable
private fun ArticleList(articles: List<Article>, onClick: (Article) -> Unit) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(articles, key = { it.url ?: it.title ?: it.hashCode().toString() }) { article ->
            ArticleCard(article = article, onClick = { onClick(article) })
        }
    }
}

@Composable
fun LoadingArticleList() {
    val dummyList = List(5) { Article(title = "", description = "", author = "", publishedAt = "", urlToImage = "", url = "") }
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(dummyList) { article ->
            ArticleCard(article = article, onClick = {}, isLoading = true)
        }
    }
}

@Composable
fun EmptyView() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Tidak ada berita untuk ditampilkan.")
    }
}

@Composable
fun ErrorView(message: String, onRetry: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Error: $message", color = MaterialTheme.colorScheme.error)
        Spacer(Modifier.height(8.dp))
        Button(onClick = onRetry) { Text("Coba Lagi") }
    }
}
