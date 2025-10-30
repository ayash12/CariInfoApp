package com.example.cariinfoapp.ui.features.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    article: com.example.cariinfoapp.data.database.model.Article?,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(article?.title ?: "Detail") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        if (article == null) {
            Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Text("Article not available")
            }
            return@Scaffold
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {

            AsyncImage(
                model = article.urlToImage,
                contentDescription = article.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                placeholder = painterResource(id = com.example.cariinfoapp.R.drawable.placeholder),
                error = painterResource(id = com.example.cariinfoapp.R.drawable.placeholder)
            )

            Spacer(modifier = Modifier.height(12.dp))
            Text(text = article.title ?: "-", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = article.publishedAt ?: "-", style = MaterialTheme.typography.labelSmall)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = article.description ?: "-", style = MaterialTheme.typography.bodyLarge)
        }
    }
}