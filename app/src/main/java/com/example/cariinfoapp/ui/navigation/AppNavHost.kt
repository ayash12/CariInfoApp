package com.example.cariinfoapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cariinfoapp.ui.features.detail.DetailScreen
import com.example.cariinfoapp.ui.features.home.HomeScreen
import com.example.cariinfoapp.ui.features.model.InfoViewModel

@Composable
fun AppNavHost (viewModel: InfoViewModel,
                isDarkMode: Boolean,
                onToggleTheme: () -> Unit,
                navController: NavHostController = rememberNavController())
{

    NavHost(navController = navController, startDestination = NavRoutes.HOME) {
        composable(NavRoutes.HOME) {
            HomeScreen(
                viewModel = viewModel,
                onArticleClick = { article ->
                    viewModel.selectArticle(article)
                    navController.navigate("detail")
                },
                onToggleTheme = onToggleTheme,
                isDarkMode = isDarkMode
            )
        }

        composable(NavRoutes.DETAIL) {
            val article = viewModel.selectedArticle.collectAsState().value
            DetailScreen(
                article = article,
                onBack = {
                    // viewModel.clearSelectedArticle()
                    navController.popBackStack()
                }
            )
        }
    }
}