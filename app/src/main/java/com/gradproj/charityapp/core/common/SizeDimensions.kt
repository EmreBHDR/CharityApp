package com.gradproj.charityapp.core.common

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class SizeDimensions(
    // Default Sizes
    val defaultElevation: Dp = 5.dp,
    val defaultMargin: Dp = 16.dp,
    val defaultPadding: Dp = 8.dp,
    val defaultBottomNavPadding: Dp = 72.dp,
    val defaultRadius: Dp = 10.dp,
    val defaultBorder: Dp = 1.dp,
    val defaultButtonWidth: Dp = 150.dp,
    val textFieldSize: Dp = 300.dp,
    val bottomDrawerItemDividerWidth: Dp = 15.dp,
    val imageSizeSmall: Dp = 24.dp
)

val LocalSize = compositionLocalOf { SizeDimensions() }