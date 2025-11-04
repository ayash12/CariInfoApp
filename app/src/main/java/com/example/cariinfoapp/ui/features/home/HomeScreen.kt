package com.example.cariinfoapp.ui.features.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cariinfoapp.data.database.model.Article
import com.example.cariinfoapp.ui.features.model.InfoViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: InfoViewModel = hiltViewModel(),
    onArticleClick: (Article) -> Unit,
    onToggleTheme: () -> Unit,
    isDarkMode: Boolean
) {
    val articlesState by viewModel.articles.collectAsState()
    val scope = rememberCoroutineScope()
    val pullToRefreshState = rememberPullToRefreshState()
    var isRefreshing by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.fetchTopHeadlines()
    }

    Scaffold(
        topBar = {
            HomeTopBar(
                isDarkMode = isDarkMode,
                onToggleTheme = onToggleTheme
            )
        }
    ) { padding ->

        PullToRefreshBox (
            state = pullToRefreshState,
            isRefreshing = isRefreshing,
            onRefresh = {
                scope.launch {
                    isRefreshing = true
                    viewModel.fetchTopHeadlines()
                    isRefreshing = false
                }
            }
        ){
            HomeContent(
                modifier = Modifier.padding(padding),
                state = articlesState,
                onArticleClick = onArticleClick,
                onRetry = { viewModel.fetchTopHeadlines() }
            )
        }
    }
}