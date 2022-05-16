package com.gradproj.charityapp.core.presentation

/**
 * Created by Emre BAHADIR on 15.12.2021
 * Copyright (c) 2021 ProcedureSoft All rights reserved.
 */
sealed class Screen(val route: String) {
    object WelcomeScreen : Screen("welcome_screen")
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
    object ForgotPasswordScreen : Screen("forgot_password_screen")
    object MapScreen : Screen("map_screen")
    object ListScreen : Screen("list_screen")
    object SettingsScreen : Screen("settings_screen")
}