package com.gradproj.charityapp.core.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.gradproj.charityapp.core.presentation.component.BasicTextView
import com.gradproj.charityapp.core.presentation.core.DarkRed

@ExperimentalPermissionsApi
@Composable
fun RequireLocationPermission(
    navigateToSettingsScreen: () -> Unit,
    content: @Composable() () -> Unit
) {
    // Permission state
    val permissionState = rememberMultiplePermissionsState(
        listOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
    )

    when {
        permissionState.allPermissionsGranted -> {
            content()
        }
        permissionState.shouldShowRationale ||
                !permissionState.permissionRequested -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DarkRed),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    BasicTextView(text = "Need to detect current location. Please grant the permission.")
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {
                                permissionState.launchMultiplePermissionRequest()
                            }
                        ) {
                            Text("Request permission")
                        }
                    }
                }
            }
        }
        else -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DarkRed),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    BasicTextView(
                        text = "Request location permission denied. " +
                                "Need current location to show nearby places. " +
                                "Please grant access on the Settings screen."
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = navigateToSettingsScreen) {
                            Text("Open Settings")
                        }
                    }
                }
            }
        }
    }
}