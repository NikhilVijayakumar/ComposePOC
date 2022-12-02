package com.nikhil.compose.ui.example.mdc.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun IconToggleButtonExample() {
    var checked by remember { mutableStateOf(false) }
    IconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
        if (checked) {
            Icon(Icons.Filled.Lock, contentDescription = "Localized description")
        } else {
            Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
        }
    }
}