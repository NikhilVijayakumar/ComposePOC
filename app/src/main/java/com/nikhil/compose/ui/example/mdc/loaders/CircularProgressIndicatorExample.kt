package com.nikhil.compose.ui.example.mdc.loaders

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun CircularProgressIndicatorExample() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CircularProgressIndicator()
    }
}