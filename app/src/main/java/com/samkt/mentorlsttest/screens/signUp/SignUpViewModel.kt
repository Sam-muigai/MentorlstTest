package com.samkt.mentorlsttest.screens.signUp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel : ViewModel() {
    private val _signUpScreenState = MutableStateFlow(SignUpScreenState())
    val signUpScreenState = _signUpScreenState.asStateFlow()

    fun onEmailChange(value: String) {
        _signUpScreenState.update {
            it.copy(
                email = value,
            )
        }
    }

    fun onPasswordChange(value: String) {
        _signUpScreenState.update {
            it.copy(
                password = value,
            )
        }
    }

    fun onUserName(value: String) {
        _signUpScreenState.update {
            it.copy(
                username = value,
            )
        }
    }

    fun onTermsToggled() {
        _signUpScreenState.update {
            it.copy(
                termsAccepted = !signUpScreenState.value.termsAccepted,
            )
        }
    }

    fun onPasswordEyeToggled() {
        _signUpScreenState.update {
            it.copy(
                passwordVisible = !signUpScreenState.value.passwordVisible,
            )
        }
    }
}
