package com.nikhil.compose.ui.example.mdc.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton

@Preview(showBackground = true)
@Composable
fun SmallFloatingActionButtonExample() {
    SmallFloatingActionButton(
        onClick = { /* do something */ },
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Localized description")
    }
}