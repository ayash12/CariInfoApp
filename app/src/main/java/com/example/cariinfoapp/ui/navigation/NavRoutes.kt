package com.example.cariinfoapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cariinfoapp.ui.features.detail.DetailScreen
import com.example.cariinfoapp.ui.features.home.HomeScreen
import com.example.cariinfoapp.ui.features.model.InfoViewModel

object NavRoutes {
    const val HOME = "home"
    const val DETAIL = "detail"
}

@Composable
fun AppNav(navController: NavHostController, viewModel: InfoViewModel) {
    NavHost(navController = navController, startDestination = NavRoutes.HOME) {
        composable(NavRoutes.HOME) {
            HomeScreen(
                viewModel = viewModel,
                onArticleClick = { article ->
                    viewModel.selectArticle(article)         // set shared state
                    navController.navigate(NavRoutes.DETAIL)
                }
            )
        }

        composable(NavRoutes.DETAIL) {
            val article = viewModel.selectedArticle.collectAsState().value
            DetailScreen(article = article, onBack = {
                // optional: viewModel.clearSelectedArticle()
                navController.popBackStack()
            })
        }
    }
}