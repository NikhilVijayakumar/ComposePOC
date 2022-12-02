package com.nikhil.compose.ui.example.mdc.text

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun TextExample() {
    Text(text = "Hello world", modifier = Modifier.padding(5.dp).fillMaxWidth(1f))
}