package com.samkt.mentorlsttest.screens.signIn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SignInScreen(signInViewModel: SignInViewModel = viewModel()) {
    val signInScreenState = signInViewModel.signInScreenState.collectAsState().value

    SignInScreenContent(
        signInScreenState = signInScreenState,
        onEvent = { event ->
            when (event) {
                is SignInScreenEvents.OnEmailChange -> {
                    signInViewModel.onEmailChange(event.email)
                }

                is SignInScreenEvents.OnPasswordChange -> {
                    signInViewModel.onPasswordChange(event.password)
                }

                is SignInScreenEvents.OnLoginClicked -> {
                }

                is SignInScreenEvents.OnRememberMeToggled -> {
                    signInViewModel.onRememberMeToggled()
                }

                is SignInScreenEvents.OnSignUpClicked -> {
                }
            }
        },
    )
}

@Composable
fun SignInScreenContent(
    modifier: Modifier = Modifier,
    signInScreenState: SignInScreenState,
    onEvent: (SignInScreenEvents) -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues),
        ) {
        }
    }
}
