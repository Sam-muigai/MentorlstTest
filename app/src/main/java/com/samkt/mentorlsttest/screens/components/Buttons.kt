package com.samkt.mentorlsttest.screens.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MentorlstButton(
    modifier: Modifier = Modifier,
    title: String = "",
    contentPadding: PaddingValues =
        PaddingValues(
            start = 24.dp,
            top = 12.dp,
            end = 24.dp,
            bottom = 12.dp,
        ),
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        onClick = onClick,
        contentPadding = contentPadding,
    ) {
        Text(
            text = title,
            style =
                MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
        )
    }
}

@Composable
fun MentorlstAltButton(
    modifier: Modifier = Modifier,
    unClickableText: String = "",
    clickableText: String = "",
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = unClickableText,
            style = MaterialTheme.typography.labelLarge,
        )
        TextButton(onClick = onClick) {
            Text(
                text = clickableText,
                style = MaterialTheme.typography.labelLarge,
            )
        }
    }
}
