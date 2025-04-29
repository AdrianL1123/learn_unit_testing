package com.example.unit_testing.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _greetings = MutableStateFlow("")
    val greetings = _greetings.asStateFlow()

    fun greet(name: String) {
        viewModelScope.launch {
            delay(1000)
            _greetings.value = "Hello $name"
        }
    }

    fun login(email: String, pass: String) {
    }

    fun validateEmail(email: String): String? {
        return null
    }

}