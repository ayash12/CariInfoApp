package com.example.cariinfoapp.ui.features.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cariinfoapp.R
import com.example.cariinfoapp.data.database.model.Article
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

@Composable
fun ArticleCard(article: Article, onClick: () -> Unit, isLoading: Boolean = false) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .clickable(enabled = !isLoading) { if (!isLoading) onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .placeholder(visible = isLoading, highlight = PlaceholderHighlight.shimmer())
        ) {
            AsyncImage(
                model = article.urlToImage,
                contentDescription = article.title,
                modifier = Modifier.size(88.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder)
            )
            Spacer(Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = article.title ?: "No title",
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 2
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = article.author ?: "Unknown author",
                    style = MaterialTheme.typography.labelSmall
                )
                Text(
                    text = article.publishedAt ?: "",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.outline
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = article.description ?: "-",
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3
                )
            }
        }
    }
}
