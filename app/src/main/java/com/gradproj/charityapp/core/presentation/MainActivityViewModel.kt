package com.gradproj.charityapp.core.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor() : ViewModel() {

    private var _userCurrentLng = mutableStateOf(0.0)
    var userCurrentLng : MutableState<Double> = _userCurrentLng

    private var _userCurrentLat = mutableStateOf(0.0)
    var userCurrentLat : MutableState<Double> = _userCurrentLat

    private var _locationPermissionGranted = MutableLiveData(false)
    var locationPermissionGranted : LiveData<Boolean> = _locationPermissionGranted

    fun currentUserGeoCOord(latLng: LatLng){
        _userCurrentLat.value = latLng.latitude
        _userCurrentLng.value = latLng.longitude
    }

    fun permissionGrand(setGranted: Boolean){
        _locationPermissionGranted.value = setGranted
    }
}