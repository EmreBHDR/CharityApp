package com.gradproj.charityapp.core.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.BottomDrawerState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gradproj.charityapp.features.forgot_password.ForgotPasswordScreen
import com.gradproj.charityapp.features.login.LoginScreen
import com.gradproj.charityapp.features.map.MapScreen
import com.gradproj.charityapp.features.register.RegisterScreen
import com.gradproj.charityapp.features.welcome.WelcomeScreen

/**
 * Created by Emre BAHADIR on 27.12.2021
 * Copyright (c) 2021 ProcedureSoft All rights reserved.
 */
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun Navigation(
    navController: NavHostController,
    scaffoldState: ScaffoldState
) {
    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route
    ) {
        composable(
            route = Screen.WelcomeScreen.route
        ) {
            WelcomeScreen(navController)
        }

        composable(
            route = Screen.LoginScreen.route
        ) {
            LoginScreen(navController)
        }

        composable(
            route = Screen.RegisterScreen.route
        ) {
            RegisterScreen(navController)
        }

        composable(
            route = Screen.ForgotPasswordScreen.route
        ) {
            ForgotPasswordScreen(navController)
        }

        composable(
            route = Screen.MapScreen.route
        ) {
            MapScreen(navController)
        }
    }
}