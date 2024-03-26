package com.samkt.mentorlsttest.screens.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samkt.mentorlsttest.R
import com.samkt.mentorlsttest.ui.theme.MentorlstTestTheme

@Composable
fun MentorlstTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    placeHolder: String = "",
    colors: TextFieldColors =
        OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
        ),
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        shape = MaterialTheme.shapes.large,
        textStyle = MaterialTheme.typography.bodyLarge,
        placeholder = {
            Text(
                text = placeHolder,
                style =
                    MaterialTheme.typography.bodyLarge.copy(
                        MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
                    ),
            )
        },
        colors = colors,
    )
}

@Composable
fun MentorlstPasswordTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    placeHolder: String = "",
    colors: TextFieldColors =
        OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
        ),
    isPasswordVisible: Boolean = false,
    onTrailingIconClicked: () -> Unit,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        shape = MaterialTheme.shapes.large,
        textStyle = MaterialTheme.typography.bodyLarge,
        placeholder = {
            Text(
                text = placeHolder,
                style =
                    MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
                    ),
            )
        },
        colors = colors,
        trailingIcon = {
            IconButton(onClick = onTrailingIconClicked) {
                Icon(
                    painter = painterResource(id = if (isPasswordVisible) R.drawable.eye_closed else R.drawable.eye_open),
                    contentDescription = null,
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun MentorlstTextFieldPreview() {
    MentorlstTestTheme {
        MentorlstTextField(
            modifier = Modifier.padding(4.dp),
        )
    }
}
