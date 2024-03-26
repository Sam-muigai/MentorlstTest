package com.samkt.mentorlsttest.screens.signUp

data class SignUpScreenState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false,
    val termsAccepted: Boolean = false,
)
