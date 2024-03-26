package com.samkt.mentorlsttest.screens.signUp

sealed class SignUpScreenEvents {
    data object OnSignUpButtonClicked : SignUpScreenEvents()

    data class OnUserNameChange(val username: String) : SignUpScreenEvents()

    data class OnPasswordChange(val password: String) : SignUpScreenEvents()

    data class OnEmailChange(val email: String) : SignUpScreenEvents()

    data object OnTermsToggled : SignUpScreenEvents()
    data object OnPasswordEyeToggled : SignUpScreenEvents()

}
