package com.gradproj.charityapp.core.presentation.component

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.gradproj.charityapp.core.presentation.core.TextWhite

@Composable
fun BasicTextView(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = MaterialTheme.typography.body1,
    color: Color = TextWhite,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        modifier = modifier,
        text = text,
        style = style,
        color = color,
        textAlign = textAlign
    )
}