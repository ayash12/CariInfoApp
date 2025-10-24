package com.example.cariinfoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cariinfoapp.ui.features.home.HomeScreen
import com.example.cariinfoapp.ui.features.model.InfoViewModel
import com.example.cariinfoapp.ui.theme.CariInfoAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel: InfoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CariInfoAppTheme {
                Surface(
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(viewModel = viewModel)
                }
            }
        }
    }
}

