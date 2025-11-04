package com.example.cariinfoapp.ui.features.detail

import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import com.example.cariinfoapp.data.database.model.Article

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    article: Article?,
    onBack: () -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            DetailTopBar(
                onBack = onBack,
                articleUrl = article?.url,
            )
        }
    ) { padding ->
        when {
            article == null -> DetailEmptyView(modifier = Modifier.padding(padding))
            else -> DetailContent(article = article, modifier = Modifier.padding(padding))
        }
    }
}
