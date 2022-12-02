package com.nikhil.compose.ui.example.mdc.surface

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SurfaceExample1() {
    var selected by remember { mutableStateOf(false) }
    Surface(
        selected = selected,
        onClick = { selected = !selected },
    ) {
        Text(
            text = if (selected) "Selected" else "Not Selected",
            textAlign = TextAlign.Center
        )
    }
}