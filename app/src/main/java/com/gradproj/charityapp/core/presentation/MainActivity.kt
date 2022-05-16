package com.gradproj.charityapp.core.presentation

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import com.gradproj.charityapp.R
import com.gradproj.charityapp.core.common.LocalSize
import com.gradproj.charityapp.core.common.LocalSpacing
import com.gradproj.charityapp.core.presentation.component.BottomNavItemView
import com.gradproj.charityapp.core.presentation.core.CharityAppTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@ExperimentalPermissionsApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CharityAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val spacing = LocalSpacing.current
                    val localSize = LocalSize.current

                    val context = LocalContext.current
                    RequireLocationPermission(navigateToSettingsScreen = {
                        context.startActivity(
                            Intent(
                                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                Uri.fromParts("package", context.packageName, null)
                            )
                        )
                    }) {
                        Text("Location Permission Accessible")
                    }

                    window.statusBarColor = ContextCompat.getColor(
                        this,
                        if (isSystemInDarkTheme()) R.color.background_dark else R.color.background_light
                    )

                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()

                    val scaffoldState = rememberScaffoldState()

                    val scope = rememberCoroutineScope()

                    var selectedBottomItem by remember { mutableStateOf(0) }
                    Scaffold(
                        bottomBar = {
                            if (checkShowBottomBar(navBackStackEntry?.destination?.route)) {
                                BottomAppBar(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    cutoutShape = CircleShape
                                ) {
                                    BottomNavigation(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        backgroundColor = MaterialTheme.colors.surface
                                    ) {
                                        BottomNavigationItem(
                                            selected = selectedBottomItem == 0,
                                            onClick = {
                                                selectedBottomItem = 0
                                            },
                                            icon = {
                                                BottomNavItemView(
                                                    isSelected = selectedBottomItem == 0,
                                                    image = R.drawable.ic_map
                                                )
                                            }
                                        )

                                        BottomNavigationItem(
                                            selected = selectedBottomItem == 1,
                                            onClick = {
                                                selectedBottomItem =1
                                            },
                                            icon = {
                                                BottomNavItemView(
                                                    isSelected = selectedBottomItem == 1,
                                                    image = R.drawable.ic_list
                                                )
                                            }
                                        )

                                        BottomNavigationItem(
                                            selected = selectedBottomItem == 2,
                                            onClick = {
                                                selectedBottomItem = 2
                                            },
                                            icon = {
                                                BottomNavItemView(
                                                    isSelected = selectedBottomItem == 2,
                                                    image = R.drawable.ic_settings
                                                )
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    ) {
                        Navigation(navController, scaffoldState)
                    }
                }
            }
        }
    }

    private fun checkShowBottomBar(route: String?) = route?.let {
        it == Screen.MapScreen.route || it == Screen.ListScreen.route || it == Screen.SettingsScreen.route
    } ?: false

    private fun getLocationPermission(permissionState: MultiplePermissionsState) {
        if (ContextCompat.checkSelfPermission(this.applicationContext, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            viewModel.permissionGrand(true)
            getDeviceLocation()

        }else{

        }
    }

    private  fun getDeviceLocation(){
        val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        try {
            if (viewModel.locationPermissionGranted.value ==true){
                val locationResult = fusedLocationProviderClient.lastLocation

                locationResult.addOnCompleteListener {
                        task ->
                    if (task.isSuccessful){
                        val lastKnownLocation = task.result

                        if (lastKnownLocation != null){
                            viewModel.currentUserGeoCOord(
                                LatLng(
                                    lastKnownLocation.altitude,
                                    lastKnownLocation.longitude
                                )
                            )
                        }
                    }else{
                        Timber.d("Exception"," Current User location is null")
                    }
                }

            }

        }catch (e: SecurityException){
            Timber.d("Exception", "Exception:  $e.message.toString()")
        }
    }
}