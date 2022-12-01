package com.nikhil.compose.ui.example.mdc

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TextFieldExample4() {
    val errorMessage = "Text input too long"
    var text by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }
    val charLimit = 10

    fun validate(text: String) {
        isError = text.length > charLimit
    }

    TextField(
        value = text,
        onValueChange = {
            text = it
            validate(text)
        },
        singleLine = true,
        label = { Text(if (isError) "Username*" else "Username") },
        supportingText = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Limit: ${text.length}/$charLimit",
                textAlign = TextAlign.End,
            )
        },
        isError = isError,
        keyboardActions = KeyboardActions { validate(text) },
        modifier = Modifier.semantics {
            // Provide localized description of the error
            if (isError) error(errorMessage)
        }
    )
}