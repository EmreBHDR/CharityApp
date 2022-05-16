package com.gradproj.charityapp.core.common

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Created by Emre BAHADIR on 18.02.2022
 * Copyright (c) 2022 ProcedureSoft All rights reserved.
 */
data class SpaceDimensions(
    val default: Dp = 0.dp,
    val spaceXXSmall: Dp = 2.dp,
    val spaceXSmall: Dp = 4.dp,
    val spaceSmall: Dp = 8.dp,
    val spaceMedium: Dp = 16.dp,
    val spaceLarge: Dp = 32.dp,
    val spaceXLarge: Dp = 64.dp,
    val spaceXXLarge: Dp = 128.dp
)

val LocalSpacing = compositionLocalOf { SpaceDimensions() }
