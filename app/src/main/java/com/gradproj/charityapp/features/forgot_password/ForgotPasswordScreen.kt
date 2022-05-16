package com.gradproj.charityapp.features.forgot_password

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gradproj.charityapp.core.common.LocalSize
import com.gradproj.charityapp.core.common.LocalSpacing
import com.gradproj.charityapp.core.presentation.Screen
import com.gradproj.charityapp.core.presentation.component.BasicTextView
import com.gradproj.charityapp.core.presentation.core.DarkRed

@Composable
fun ForgotPasswordScreen(
    navController: NavController,
    viewModel: ForgotPasswordViewModel = hiltViewModel()
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
                text = "Forgot Password",
                style = MaterialTheme.typography.h2
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    modifier = Modifier
                        .width(localSize.textFieldSize),
                    value = viewModel.emailValue.value,
                    placeholder = {
                        BasicTextView(
                            text = "Email"
                        )
                    },
                    onValueChange = {
                        viewModel.setInput(0, it)
                    }
                )

                Spacer(modifier = Modifier.height(spacing.spaceMedium))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier
                            .width(localSize.defaultButtonWidth),
                        onClick = {

                        }
                    ) {
                        BasicTextView(text = "Send Email")
                    }
                }
            }
        }
    }
}