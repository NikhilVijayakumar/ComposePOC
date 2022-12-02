package com.nikhil.compose.ui.example.mdc.textfield

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TextFieldExample2() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Email") },
        placeholder = { Text("example@gmail.com") }
    )
}