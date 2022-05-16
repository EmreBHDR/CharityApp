package com.gradproj.charityapp.core.presentation.core

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.gradproj.charityapp.core.common.LocalSize
import com.gradproj.charityapp.core.common.LocalSpacing
import com.gradproj.charityapp.core.common.SizeDimensions
import com.gradproj.charityapp.core.common.SpaceDimensions

private val DarkColorPalette = darkColors(
    primary = PrimaryDark,
    secondary = SecondaryDark,
    secondaryVariant = SecondaryVariantDark,
    background = BackgroundDark,
    surface = SurfaceDark,
    error = ErrorDark,
    onPrimary = OnPrimaryDark,
    onSecondary = OnSecondaryDark,
    onSurface = OnSurfaceDark
)

private val LightColorPalette = lightColors(
    primary = PrimaryLight,
    secondary = SecondaryLight,
    secondaryVariant = SecondaryVariantLight,
    background = BackgroundLight,
    surface = SurfaceLight,
    error = ErrorLight,
    onPrimary = OnPrimaryLight,
    onSecondary = OnSecondaryLight,
    onSurface = OnSurfaceLight
)

@Composable
fun CharityAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    CompositionLocalProvider(LocalSpacing provides SpaceDimensions(), LocalSize provides SizeDimensions()) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}