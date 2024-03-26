package com.samkt.mentorlsttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.samkt.mentorlsttest.screens.navigation.AppScreens
import com.samkt.mentorlsttest.screens.signIn.SignInScreen
import com.samkt.mentorlsttest.screens.signUp.SignUpScreen
import com.samkt.mentorlsttest.ui.theme.MentorlstTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MentorlstTestTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = AppScreens.SignUpScreen.route) {
        composable(AppScreens.SignUpScreen.route) {
            SignUpScreen(navController = navController)
        }
        composable(AppScreens.SignInScreen.route) {
            SignInScreen()
        }
    }
}
