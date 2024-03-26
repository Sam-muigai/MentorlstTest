package com.samkt.mentorlsttest.screens.signUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.samkt.mentorlsttest.R
import com.samkt.mentorlsttest.screens.components.MentorlistCheckBox
import com.samkt.mentorlsttest.screens.components.MentorlstAltButton
import com.samkt.mentorlsttest.screens.components.MentorlstButton
import com.samkt.mentorlsttest.screens.components.MentorlstPasswordTextField
import com.samkt.mentorlsttest.screens.components.MentorlstTextField
import com.samkt.mentorlsttest.screens.navigation.AppScreens

@Composable
fun SignUpScreen(signUpViewModel: SignUpViewModel = viewModel(),
                 navController: NavHostController) {
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
                    navController.navigate(AppScreens.SignInScreen.route)
                }

                is SignUpScreenEvents.OnTermsToggled -> {
                    signUpViewModel.onTermsToggled()
                }

                is SignUpScreenEvents.OnUserNameChange -> {
                    signUpViewModel.onUserName(event.username)
                }

                SignUpScreenEvents.OnPasswordEyeToggled -> {
                    signUpViewModel.onPasswordEyeToggled()
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
        modifier =
        modifier
            .fillMaxSize()
            .padding(12.dp),
    ) { paddingValues ->
        Column(
            modifier =
            Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.create_account),
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.username),
                style =
                    MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                    ),
            )
            MentorlstTextField(
                value = signUpScreenState.username,
                onValueChange = {
                    onEvent(SignUpScreenEvents.OnUserNameChange(it))
                },
                placeHolder = stringResource(id = R.string.username_placeholder),
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = stringResource(id = R.string.email),
                style =
                    MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                    ),
            )
            MentorlstTextField(
                value = signUpScreenState.email,
                onValueChange = {
                    onEvent(SignUpScreenEvents.OnEmailChange(it))
                },
                placeHolder = stringResource(id = R.string.email_placeholder),
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = stringResource(id = R.string.password),
                style =
                    MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                    ),
            )
            MentorlstPasswordTextField(
                value = signUpScreenState.password,
                onValueChange = {
                    onEvent(SignUpScreenEvents.OnPasswordChange(it))
                },
                placeHolder = stringResource(id = R.string.password_placeholder),
                onTrailingIconClicked = {
                    onEvent(SignUpScreenEvents.OnPasswordEyeToggled)
                },
                isPasswordVisible = signUpScreenState.passwordVisible,
            )
            Spacer(modifier = Modifier.padding(8.dp))
            MentorlistCheckBox(
                checked = signUpScreenState.termsAccepted,
                onCheckChange = {
                    onEvent(SignUpScreenEvents.OnTermsToggled)
                },
                description = stringResource(id = R.string.accept_terms),
            )
            Spacer(modifier = Modifier.padding(16.dp))
            MentorlstButton(
                title = stringResource(id = R.string.sign_up),
                onClick = {
                    onEvent(SignUpScreenEvents.OnSignUpButtonClicked)
                },
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                MentorlstAltButton(
                    unClickableText = stringResource(id = R.string.have_an_account),
                    clickableText = stringResource(id = R.string.log_in),
                    onClick = {
                        onEvent(SignUpScreenEvents.OnSignUpButtonClicked)
                    },
                )
            }
        }
    }
}

// @Preview(showSystemUi = true)
// @Composable
// fun SignUpScreenPreview() {
//    MentorlstTestTheme {
//    }
// }
