package com.nikhil.compose.ui.example.mdc.snackbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SuggestionChipExample() {
    SuggestionChip(
        onClick = { /* Do something! */ },
        label = { Text("Suggestion Chip") }
    )
}