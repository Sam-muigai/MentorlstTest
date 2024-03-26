package com.samkt.mentorlsttest.screens.signIn

data class SignInScreenState(
    val username: String = "",
    val password: String = "",
    val rememberMeToggled: Boolean = false,
    val passwordVisible: Boolean = false,
)
