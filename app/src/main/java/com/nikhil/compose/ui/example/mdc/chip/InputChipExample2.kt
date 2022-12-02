package com.nikhil.compose.ui.example.mdc.chip

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun InputChipExample2() {
    var selected by remember { mutableStateOf(false) }
    InputChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text("Input Chip") },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        }
    )
}