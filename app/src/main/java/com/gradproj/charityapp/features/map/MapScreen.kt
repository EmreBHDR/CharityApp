package com.gradproj.charityapp.features.map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.gradproj.charityapp.core.presentation.core.DarkRed
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import com.gradproj.charityapp.core.common.LocalSize
import com.gradproj.charityapp.core.common.LocalSpacing

@Composable
fun MapScreen(
    navController: NavController
) {
    val spacing = LocalSpacing.current
    val localSize = LocalSize.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkRed)
    ) {
        val singapore = LatLng(1.35, 103.87)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(singapore, 10f)
        }
        GoogleMap(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = localSize.defaultPadding,
                    start = localSize.defaultPadding,
                    end = localSize.defaultPadding,
                    bottom = localSize.defaultBottomNavPadding
                ),
            properties = MapProperties(),
            uiSettings = MapUiSettings(zoomControlsEnabled = false),
            cameraPositionState = cameraPositionState
        )
    }
}