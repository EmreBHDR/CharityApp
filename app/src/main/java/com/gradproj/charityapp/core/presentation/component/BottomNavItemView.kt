package com.gradproj.charityapp.core.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import com.gradproj.charityapp.core.common.LocalSize
import com.gradproj.charityapp.core.common.LocalSpacing

@Composable
fun BottomNavItemView(
    isSelected: Boolean = false,
    @DrawableRes image: Int = -1
) {
    val spacing = LocalSpacing.current
    val localSize = LocalSize.current

    val lineLength = animateFloatAsState(
        targetValue = if (isSelected) 1f else 0f,
        animationSpec = tween(
            durationMillis = 300
        )
    )

    val selectedColor = MaterialTheme.colors.primary
    val unselectedColor = MaterialTheme.colors.onSurface
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceSmall)
            .drawBehind {
                if (lineLength.value > 0f) {
                    drawLine(
                        color = selectedColor,
                        start = Offset(
                            size.width / 2f - lineLength.value * localSize.bottomDrawerItemDividerWidth.toPx(),
                            size.height
                        ),
                        end = Offset(
                            size.width / 2f + lineLength.value * localSize.bottomDrawerItemDividerWidth.toPx(),
                            size.height
                        ),
                        strokeWidth = localSize.defaultBorder.toPx(),
                        cap = StrokeCap.Round
                    )
                }
            }
    ) {
        Image(
            modifier = Modifier
                .size(localSize.imageSizeSmall)
                .align(Alignment.Center),
            painter = painterResource(id = image),
            contentDescription = "BottomBarNavItemImage",
            colorFilter = ColorFilter.tint(
                if (isSelected) {
                    selectedColor
                } else {
                    unselectedColor
                }
            )
        )
    }
}