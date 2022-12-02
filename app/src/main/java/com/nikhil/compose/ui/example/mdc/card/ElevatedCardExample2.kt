package com.nikhil.compose.ui.example.mdc.card

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ElevatedCardExample2() {
    ElevatedCard(
        onClick = { /* Do something */ },
        modifier = Modifier.size(width = 180.dp, height = 100.dp)
    ) {
        Box(Modifier.fillMaxSize()) {
            Text("Clickable", Modifier.align(Alignment.Center))
        }
    }
}