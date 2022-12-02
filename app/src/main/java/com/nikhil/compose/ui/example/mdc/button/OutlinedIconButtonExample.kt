package com.nikhil.compose.ui.example.mdc.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton

@Preview(showBackground = true)
@Composable
fun OutlinedIconButtonExample() {
    OutlinedIconButton(onClick = { /* doSomething() */ }) {
        Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
    }
}