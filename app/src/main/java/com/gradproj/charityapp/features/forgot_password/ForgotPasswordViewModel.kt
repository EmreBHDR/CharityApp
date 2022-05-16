package com.gradproj.charityapp.features.forgot_password

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(): ViewModel() {

    private val _emailValue = mutableStateOf<String>("")
    val emailValue: State<String> = _emailValue

    fun setInput(inputType: Int, value: String) {
        when(inputType) {
            0 -> {
                _emailValue.value = value
            }
        }
    }
}