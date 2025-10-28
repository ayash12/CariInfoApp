package com.example.cariinfoapp.ui.theme


import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

data class MyColors(
    val material: ColorScheme,
    val chip: Color,
    val iconTint: Color
) {
    val primary: Color get() = material.primary
    val primaryVariant: Color get() = material.primaryFixed
    val secondary: Color get() = material.secondary
    val secondaryVariant: Color get() = material.secondaryFixed
    val background: Color get() = material.background
    val surface: Color get() = material.surface
    val error: Color get() = material.error
    val onPrimary: Color get() = material.onPrimary
    val onSecondary: Color get() = material.onSecondary
    val onBackground: Color get() = material.onBackground
    val onSurface: Color get() = material.onSurface
    val onError: Color get() = material.onError
//    val isLight: Boolean get() = material.isLight
}
