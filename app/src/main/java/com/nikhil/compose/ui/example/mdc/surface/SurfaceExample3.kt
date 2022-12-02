package com.nikhil.compose.ui.example.mdc.surface

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SurfaceExample3() {
    var count by remember { mutableStateOf(0) }
    Surface(
        onClick = { count++ },
    ) {
        Text("Clickable Surface. Count: $count")
    }
}