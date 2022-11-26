package com.nikhil.compose.ui.example.mdc

import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun ExtendedFloatingActionButtonExample() {
    ExtendedFloatingActionButton(onClick = { /* do something */ }) {
        Text(text = "Extended FAB")
    }
}