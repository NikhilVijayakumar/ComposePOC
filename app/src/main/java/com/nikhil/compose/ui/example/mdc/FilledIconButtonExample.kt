package com.nikhil.compose.ui.example.mdc

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon



@Preview(showBackground = true)
@Composable
fun FilledIconButtonExample() {
    FilledIconButton(onClick = { /* doSomething() */ }) {
        Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
    }
}