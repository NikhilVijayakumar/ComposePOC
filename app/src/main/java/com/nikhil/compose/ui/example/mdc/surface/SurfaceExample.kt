package com.nikhil.compose.ui.example.mdc.surface

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Surface
import androidx.compose.material3.Text



@Preview(showBackground = true)
@Composable
fun SurfaceExample() {
    Surface {
        Text("Text on Surface")
    }
}