package com.samkt.mentorlsttest.screens.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.samkt.mentorlsttest.R

@Composable
fun MentorlistRadioButton(
    modifier: Modifier = Modifier,
    description: String = "",
    checked: Boolean = false,
    onCheckChange: () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CircleCheckbox(selected = checked, onChecked = onCheckChange)
        Text(
            text = description,
            style =
                MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
        )
    }
}

@Composable
fun CircleCheckbox(
    modifier: Modifier = Modifier,
    selected: Boolean,
    enabled: Boolean = true,
    onChecked: () -> Unit,
) {
    val icon = if (selected) R.drawable.circle_checked else R.drawable.circle
    IconButton(
        onClick = { onChecked() },
        modifier = modifier.wrapContentSize(),
        enabled = enabled,
    ) {
        Icon(
            painter = painterResource(id = icon),
            modifier = Modifier.size(25.dp),
            contentDescription = null,
        )
    }
}
