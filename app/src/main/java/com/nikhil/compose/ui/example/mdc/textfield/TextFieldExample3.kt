package com.nikhil.compose.ui.example.mdc.textfield

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TextFieldExample3() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
        leadingIcon = { Icon(Icons.Filled.Favorite, contentDescription = "Localized description") },
        trailingIcon = { Icon(Icons.Filled.Info, contentDescription = "Localized description") }
    )
}