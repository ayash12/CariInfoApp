package com.example.cariinfoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.cariinfoapp.ui.features.model.InfoViewModel
import com.example.cariinfoapp.ui.navigation.AppNavHost
import com.example.cariinfoapp.ui.theme.CariInfoAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: InfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // theme toggle state (activity-scoped)
            val isDark = remember { mutableStateOf(false) }

            CariInfoAppTheme(darkTheme = isDark.value) {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavHost(
                        viewModel = viewModel,
                        isDarkMode = isDark.value,
                        onToggleTheme = { isDark.value = !isDark.value }
                    )
                }
            }
        }
    }
}

