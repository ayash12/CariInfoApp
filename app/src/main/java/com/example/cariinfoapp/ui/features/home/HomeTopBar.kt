package com.example.cariinfoapp.ui.features.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.cariinfoapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    isDarkMode: Boolean,
    onToggleTheme: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text("CariInfoApp") },
        actions = {
            IconButton(onClick = onToggleTheme) {
                Icon(
                    painter = painterResource(
                        id = if (isDarkMode) R.drawable.ic_light_mode else R.drawable.ic_dark_mode
                    ),
                    contentDescription = "Toggle Theme"
                )
            }
        }
    )
}