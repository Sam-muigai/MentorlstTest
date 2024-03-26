package com.samkt.mentorlsttest.screens.signIn

sealed class SignInScreenEvents {
    data class OnEmailChange(val email: String) : SignInScreenEvents()

    data class OnPasswordChange(val password: String) : SignInScreenEvents()

    data object OnRememberMeToggled : SignInScreenEvents()

    data object OnSignUpClicked : SignInScreenEvents()

    data object OnForgotPasswordClicked : SignInScreenEvents()

    data object OnLoginClicked : SignInScreenEvents()

    data object OnPasswordEyeToggled : SignInScreenEvents()
}
