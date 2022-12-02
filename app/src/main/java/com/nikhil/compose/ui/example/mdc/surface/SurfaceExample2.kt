package com.nikhil.compose.ui.example.mdc.surface

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SurfaceExample2() {
    var checked by remember { mutableStateOf(false) }
    Surface(
        checked = checked,
        onCheckedChange = { checked = !checked },
        color = if (checked) {
            MaterialTheme.colorScheme.surfaceVariant
        } else {
            MaterialTheme.colorScheme.surface
        }
    ) {
        Text(
            text = if (checked) "ON" else "OFF",
            textAlign = TextAlign.Center
        )
    }
}