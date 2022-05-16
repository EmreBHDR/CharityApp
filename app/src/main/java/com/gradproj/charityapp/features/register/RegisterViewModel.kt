package com.gradproj.charityapp.features.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    private val _emailValue = mutableStateOf<String>("")
    val emailValue: State<String> = _emailValue

    private val _nameSurname = mutableStateOf<String>("")
    val nameSurname: State<String> = _nameSurname

    private val _password = mutableStateOf<String>("")
    val password: State<String> = _password

    private val _confirmPassword = mutableStateOf<String>("")
    val confirmPassword: State<String> = _confirmPassword

    fun setInput(inputType: Int, value: String) {
        when(inputType) {
            0 -> {
                _emailValue.value = value
            }
            1 -> {
                _nameSurname.value = value
            }
            2 -> {
                _password.value = value
            }
            3 -> {
                _confirmPassword.value = value
            }
        }
    }
}