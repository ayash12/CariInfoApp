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

