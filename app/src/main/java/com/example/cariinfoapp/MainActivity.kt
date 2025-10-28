package com.example.cariinfoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.cariinfoapp.ui.features.home.HomeScreen
import com.example.cariinfoapp.ui.features.model.InfoViewModel
import com.example.cariinfoapp.ui.theme.CariInfoAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: InfoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CariInfoAppTheme {
                    HomeScreen()
            }
        }
    }
}

