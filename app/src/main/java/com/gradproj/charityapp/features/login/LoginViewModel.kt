package com.gradproj.charityapp.features.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _emailValue = mutableStateOf<String>("")
    val emailValue: State<String> = _emailValue

    private val _password = mutableStateOf<String>("")
    val password: State<String> = _password

    fun setInput(inputType: Int, value: String) {
        when(inputType) {
            0 -> {
                _emailValue.value = value
            }
            1 -> {
                _password.value = value
            }
        }
    }
}