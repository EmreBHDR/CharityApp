package com.gradproj.charityapp.features.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gradproj.charityapp.core.common.LocalSize
import com.gradproj.charityapp.core.common.LocalSpacing
import com.gradproj.charityapp.core.presentation.Screen
import com.gradproj.charityapp.core.presentation.component.BasicTextView
import com.gradproj.charityapp.core.presentation.core.DarkRed
import com.gradproj.charityapp.core.presentation.core.TextWhite
import com.gradproj.charityapp.core.presentation.core.quicksand

@Composable
fun WelcomeScreen(
    navController: NavController
) {
    val spacing = LocalSpacing.current
    val localSize = LocalSize.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkRed)
    ) {
        Column {
            Spacer(modifier = Modifier.height(spacing.spaceXLarge))

            BasicTextView(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Charity App",
                style = MaterialTheme.typography.h2
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Button(
                    modifier = Modifier
                        .width(localSize.defaultButtonWidth),
                    onClick = {
                        navController.navigate(Screen.LoginScreen.route)
                    }
                ) {
                    BasicTextView(text = "Login")
                }

                Spacer(modifier = Modifier.height(spacing.spaceMedium))

                Button(
                    modifier = Modifier
                        .width(localSize.defaultButtonWidth),
                    onClick = {
                        navController.navigate(Screen.RegisterScreen.route)
                    }
                ) {
                    BasicTextView(text = "Register")
                }

                Spacer(modifier = Modifier.height(spacing.spaceMedium))

                BasicTextView(
                    modifier = Modifier
                        .width(localSize.defaultButtonWidth)
                        .clickable {
                            navController.navigate(Screen.ForgotPasswordScreen.route)
                        },
                    text = "Forgot Password?",
                    style = TextStyle(
                        textDecoration = TextDecoration.combine(
                            listOf(
                                TextDecoration.Underline
                            )
                        ),
                        fontFamily = quicksand,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}