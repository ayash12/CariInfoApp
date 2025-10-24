package com.example.cariinfoapp.ui.features.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cariinfoapp.ui.features.model.InfoViewModel

@Composable
fun HomeScreen(
    viewModel: InfoViewModel = viewModel()
) {
    val articles by viewModel.articles.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchTopHeadlines()
    }

    if (articles.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(articles) { article ->
                Text(
                    text = article.title ?: "No title",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
