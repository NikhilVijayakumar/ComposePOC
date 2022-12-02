package com.nikhil.compose.ui.example.mdc.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Preview(showBackground = true)
@Composable
fun IconButtonExample() {
    IconButton(onClick = { /* doSomething() */ }) {
        Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
    }
}