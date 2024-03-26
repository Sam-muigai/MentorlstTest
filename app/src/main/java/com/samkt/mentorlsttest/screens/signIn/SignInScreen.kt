package com.samkt.mentorlsttest.screens.signIn

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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.samkt.mentorlsttest.R
import com.samkt.mentorlsttest.screens.components.MentorlistCheckBox
import com.samkt.mentorlsttest.screens.components.MentorlstAltButton
import com.samkt.mentorlsttest.screens.components.MentorlstButton
import com.samkt.mentorlsttest.screens.components.MentorlstPasswordTextField
import com.samkt.mentorlsttest.screens.components.MentorlstTextField
import com.samkt.mentorlsttest.ui.theme.MentorlstTestTheme

@Composable
fun SignInScreen(signInViewModel: SignInViewModel = viewModel()) {
    val signInScreenState = signInViewModel.signInScreenState.collectAsState().value

    SignInScreenContent(
        signInScreenState = signInScreenState,
        onEvent = { event ->
            when (event) {
                is SignInScreenEvents.OnUsernameChange -> {
                    signInViewModel.onUsernameChange(event.username)
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

                SignInScreenEvents.OnPasswordEyeToggled -> {
                    signInViewModel.onPasswordEyeToggled()
                }

                SignInScreenEvents.OnForgotPasswordClicked -> {
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
            modifier =
                modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(8.dp),
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.sign_in),
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
                value = signInScreenState.username,
                onValueChange = {
                    onEvent(SignInScreenEvents.OnUsernameChange(it))
                },
                placeHolder = stringResource(id = R.string.username_placeholder),
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
                value = signInScreenState.password,
                onValueChange = {
                    onEvent(SignInScreenEvents.OnPasswordChange(it))
                },
                placeHolder = stringResource(id = R.string.password_placeholder),
                onTrailingIconClicked = {
                    onEvent(SignInScreenEvents.OnPasswordEyeToggled)
                },
                isPasswordVisible = signInScreenState.passwordVisible,
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                MentorlistCheckBox(
                    checked = signInScreenState.rememberMeToggled,
                    onCheckChange = {
                        onEvent(SignInScreenEvents.OnRememberMeToggled)
                    },
                    description = stringResource(id = R.string.remember_me),
                )
                TextButton(onClick = {
                    onEvent(
                        SignInScreenEvents.OnForgotPasswordClicked,
                    )
                }) {
                    Text(
                        text = stringResource(id = R.string.forgot_password),
                        style =
                            MaterialTheme.typography.labelLarge.copy(
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onBackground,
                            ),
                    )
                }
            }
            Spacer(modifier = Modifier.padding(16.dp))
            MentorlstButton(
                title = stringResource(id = R.string.sign_in),
                onClick = {
                    onEvent(SignInScreenEvents.OnLoginClicked)
                },
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                MentorlstAltButton(
                    unClickableText = stringResource(id = R.string.no_account),
                    clickableText = stringResource(id = R.string.sign_up),
                    onClick = {
                        onEvent(SignInScreenEvents.OnSignUpClicked)
                    },
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SignInScreenPreview() {
    MentorlstTestTheme {
        SignInScreenContent(
            signInScreenState = SignInScreenState(),
            onEvent = {},
        )
    }
}
