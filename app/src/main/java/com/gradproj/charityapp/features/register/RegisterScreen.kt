package com.gradproj.charityapp.features.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gradproj.charityapp.R
import com.gradproj.charityapp.core.common.LocalSize
import com.gradproj.charityapp.core.common.LocalSpacing
import com.gradproj.charityapp.core.presentation.Screen
import com.gradproj.charityapp.core.presentation.component.BasicTextView
import com.gradproj.charityapp.core.presentation.core.DarkRed
import com.gradproj.charityapp.core.presentation.core.TextGray

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
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
                text = "Register",
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

                TextField(
                    modifier = Modifier
                        .width(localSize.textFieldSize),
                    value = viewModel.nameSurname.value,
                    placeholder = {
                        BasicTextView(
                            text = "Name Surname"
                        )
                    },
                    onValueChange = {
                        viewModel.setInput(1, it)
                    }
                )

                Spacer(modifier = Modifier.height(spacing.spaceMedium))

                TextField(
                    modifier = Modifier
                        .width(localSize.textFieldSize),
                    value = viewModel.password.value,
                    placeholder = {
                        BasicTextView(
                            text = "Password"
                        )
                    },
                    onValueChange = {
                        viewModel.setInput(2, it)
                    },
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(spacing.spaceMedium))

                TextField(
                    modifier = Modifier
                        .width(localSize.textFieldSize),
                    value = viewModel.confirmPassword.value,
                    placeholder = {
                        BasicTextView(
                            text = "Confirm Password"
                        )
                    },
                    onValueChange = {
                        viewModel.setInput(3, it)
                    },
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(spacing.spaceMedium))

                Box(
                    modifier = Modifier
                        .width(localSize.textFieldSize)
                        .wrapContentSize(Alignment.Center)
                ) {
                    var expanded by remember { mutableStateOf(false) }
                    val items = listOf("User", "Carrier", "Benefactor")
                    var selectedIndex by remember { mutableStateOf(0) }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colors.onSurface.copy(alpha = TextFieldDefaults.BackgroundOpacity))
                            .clickable {
                                expanded = true
                            },
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        BasicTextView(
                            modifier = Modifier
                                .padding(localSize.defaultPadding),
                            text = items[selectedIndex]
                        )

                        Image(
                            modifier = Modifier
                                .padding(localSize.defaultPadding),
                            painter = painterResource(id = R.drawable.ic_downarrow),
                            contentDescription = "Drop Down Arrow"
                        )
                    }
                    DropdownMenu(
                        modifier = Modifier
                            .width(localSize.textFieldSize),
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        items.forEachIndexed { index, s ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedIndex = index
                                    expanded = false
                                }
                            ) {
                                BasicTextView(
                                    text = s,
                                    color = TextGray
                                )
                            }
                        }
                    }
                }

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
                        BasicTextView(text = "Register")
                    }
                }
            }
        }
    }
}