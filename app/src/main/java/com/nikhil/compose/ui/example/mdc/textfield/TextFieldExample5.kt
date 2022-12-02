package com.nikhil.compose.ui.example.mdc.textfield

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TextFieldExample5() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
        supportingText = {
            Text("Supporting text that is long and perhaps goes onto another line.")
        },
    )
}