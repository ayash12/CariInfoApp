package com.example.cariinfoapp.ui.features.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.cariinfoapp.data.database.model.Article
import com.example.cariinfoapp.ui.features.model.InfoViewModel
import com.example.cariinfoapp.ui.state.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: InfoViewModel = hiltViewModel(),
               onArticleClick: (Article) -> Unit) {
    val articles by viewModel.articles.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchTopHeadlines()
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("CariInfoApp") })
        }
    ) { padding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(padding)) {
            when(articles){
                is UiState.Loading -> LoadingView()
                is UiState.Success -> {
                    val list = (articles as UiState.Success).data
                    ArticleList(articles = list, onItemClick = onArticleClick)
                }
                is UiState.Error -> {
                    val msg = (articles as UiState.Error).message
                    ErrorView(message = msg)
                }
            }

        }
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
fun ArticleList(
    articles: List<Article>,
    onItemClick: (Article) -> Unit
) {
    LazyColumn(contentPadding = PaddingValues(8.dp)) {
        items(articles, key = { it.url ?: it.title ?: it.hashCode().toString() }) { article ->
            ArticleCard(article = article, onClick = { onItemClick(article) })
        }
    }
}

@Composable
fun ArticleCard(article: Article, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            AsyncImage(
                model = article.urlToImage,
                contentDescription = article.title,
                modifier = Modifier.size(88.dp)
            )
            Spacer(Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = article.title ?: "No title", style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(6.dp))
                Text(text = article.description ?: "-", style = MaterialTheme.typography.bodyMedium, maxLines = 3)
            }
        }
    }
}