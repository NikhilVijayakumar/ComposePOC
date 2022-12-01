package com.nikhil.compose.ui.example.mdc

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton



@Preview(showBackground = true)
@Composable
fun TextButtonExample() {
    TextButton(onClick = { /* Do something! */ }) { Text("Text Button") }
}