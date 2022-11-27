package com.nikhil.compose.ui.example.mdc

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun ButtonExample() {
    Button(onClick = { /* Do something! */ }) { Text("Button") }
}
