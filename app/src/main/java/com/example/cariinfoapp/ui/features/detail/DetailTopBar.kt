package com.example.cariinfoapp.ui.features.detail

import android.content.Intent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTopBar(
    onBack: () -> Unit,
    articleUrl: String?
) {
    val context = LocalContext.current
    CenterAlignedTopAppBar(
        title = { Text("News Portal") },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Kembali"
                )
            }
        },
        actions = {
            IconButton(
                onClick = {
                    articleUrl?.let { url ->
                        val shareIntent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, url)
                            type = "text/plain"
                        }
                        val chooser = Intent.createChooser(shareIntent, "Bagikan berita via...")
                        context.startActivity(chooser)
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Bagikan"
                )
            }
        }
    )
}
