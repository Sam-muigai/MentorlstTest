package com.samkt.mentorlsttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.samkt.mentorlsttest.screens.signIn.SignInScreen
import com.samkt.mentorlsttest.ui.theme.MentorlstTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MentorlstTestTheme {
                SignInScreen()
            }
        }
    }
}
