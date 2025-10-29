package com.example.cariinfoapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cariinfoapp.ui.features.detail.DetailScreen
import com.example.cariinfoapp.ui.features.home.HomeScreen

@Composable
fun AppNavHost (navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoutes.HOME){
        composable(NavRoutes.HOME){
            HomeScreen(onArticleClick = { article ->
                navController.currentBackStackEntry?.arguments?.putParcelable("article", article)
                navController.navigate(NavRoutes.DETAIL)
            })
        }
        composable(NavRoutes.DETAIL) { backStackEntry ->
            val article = backStackEntry.arguments?.getParcelable<com.example.cariinfoapp.data.database.model.Article>("article")
            DetailScreen(article = article, onBack = { navController.popBackStack() })
        }
    }

}