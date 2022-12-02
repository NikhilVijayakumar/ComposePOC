package com.nikhil.compose.ui.example.mdc.button

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun OutlinedButtonExample() {
    OutlinedButton(onClick = { /* Do something! */ }) { Text("Outlined Button") }
}