package com.nikhil.compose.ui.example.mdc.chip
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun InputChipExample3() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            repeat(9) { index ->
                AssistChip(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    onClick = { /* do something*/ },
                    label = { Text("Chip $index") }
                )
            }
        }
    }
}