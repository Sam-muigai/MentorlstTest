package com.samkt.mentorlsttest.screens.signUp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.samkt.mentorlsttest.ui.theme.MentorlstTestTheme

@Composable
fun SignUpScreen(signUpViewModel: SignUpViewModel = viewModel()) {
    val signUpScreenState = signUpViewModel.signUpScreenState.collectAsState().value

    SignUpScreenContent(
        signUpScreenState = signUpScreenState,
        onEvent = { event ->
            when (event) {
                is SignUpScreenEvents.OnEmailChange -> {
                    signUpViewModel.onEmailChange(event.email)
                }

                is SignUpScreenEvents.OnPasswordChange -> {
                    signUpViewModel.onPasswordChange(event.password)
                }

                is SignUpScreenEvents.OnSignUpButtonClicked -> {
                    // TODO: Navigate to SignIn
                }

                is SignUpScreenEvents.OnTermsToggled -> {
                    signUpViewModel.onTermsToggled()
                }

                is SignUpScreenEvents.OnUserName -> {
                    signUpViewModel.onUserName(event.username)
                }
            }
        },
    )
}

@Composable
fun SignUpScreenContent(
    modifier: Modifier = Modifier,
    signUpScreenState: SignUpScreenState,
    onEvent: (SignUpScreenEvents) -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) { paddingValues ->
        Column(
            modifier =
                Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
        ) {
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SignUpScreenPreview() {
    MentorlstTestTheme {
    }
}
