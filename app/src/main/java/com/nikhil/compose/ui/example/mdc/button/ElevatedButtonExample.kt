package com.nikhil.compose.ui.example.mdc

import androidx.compose.runtime.Composable
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun ElevatedButtonExample() {
    ElevatedButton(onClick = { /* Do something! */ }) { Text("Elevated Button") }
}