package com.samkt.mentorlsttest.screens.navigation

sealed class AppScreens(val route: String) {
    data object SignUpScreen : AppScreens("sign_up_screen")

    data object SignInScreen : AppScreens("sign_in_screen")
}
