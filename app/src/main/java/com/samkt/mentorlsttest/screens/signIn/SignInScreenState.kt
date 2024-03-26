package com.samkt.mentorlsttest.screens.signIn

data class SignInScreenState(
    val email: String = "",
    val password: String = "",
    val rememberMeToggled: Boolean = false,
    val passwordVisible: Boolean = false,
)
