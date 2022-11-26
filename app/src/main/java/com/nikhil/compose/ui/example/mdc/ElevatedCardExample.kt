package com.nikhil.compose.ui.example.mdc

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun ElevatedCardExample() {
    ElevatedCard(Modifier.size(width = 180.dp, height = 100.dp)) {
        // Card content
    }
}