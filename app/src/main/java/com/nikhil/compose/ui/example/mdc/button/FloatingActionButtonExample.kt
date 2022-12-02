package com.nikhil.compose.ui.example.mdc.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview



@Preview(showBackground = true)
@Composable
fun FloatingActionButtonExample() {
    FloatingActionButton(
        onClick = { /* do something */ },
    ) {
        Icon(Icons.Filled.Add, "Localized description")
    }
}