package com.nikhil.compose.ui.example.mdc.chip

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElevatedFilterChipExample() {
    var selected by remember { mutableStateOf(false) }
    ElevatedFilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text("Filter chip") },
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Localized Description",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        }
    )
}