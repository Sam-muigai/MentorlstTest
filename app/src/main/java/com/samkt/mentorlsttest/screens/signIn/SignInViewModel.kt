package com.samkt.mentorlsttest.screens.signIn

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignInViewModel : ViewModel() {
    private val _signInScreenState = MutableStateFlow(SignInScreenState())
    val signInScreenState = _signInScreenState.asStateFlow()

    fun onUsernameChange(value: String) {
        _signInScreenState.update {
            it.copy(
                username = value,
            )
        }
    }

    fun onPasswordChange(value: String) {
        _signInScreenState.update {
            it.copy(
                password = value,
            )
        }
    }

    fun onRememberMeToggled() {
        _signInScreenState.update {
            it.copy(
                rememberMeToggled = !signInScreenState.value.rememberMeToggled,
            )
        }
    }

    fun onPasswordEyeToggled() {
        _signInScreenState.update {
            it.copy(
                passwordVisible = !signInScreenState.value.passwordVisible,
            )
        }
    }
}
