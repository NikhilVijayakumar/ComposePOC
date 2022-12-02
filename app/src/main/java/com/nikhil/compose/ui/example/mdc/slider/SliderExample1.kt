package com.nikhil.compose.ui.example.mdc.slider

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun SliderExample1() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Column {
        Text(text = sliderPosition.toString())
        Slider(
            modifier = Modifier.semantics { contentDescription = "Localized Description" },
            value = sliderPosition,
            onValueChange = { sliderPosition = it })
    }
}