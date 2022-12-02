package com.nikhil.compose.ui.example.mdc.button

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics


@Preview(showBackground = true)
@Composable
fun RadioButtonExample() {
// We have two radio buttons and only one can be selected
    var state by remember { mutableStateOf(true) }
// Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior.
// We also set a content description for this sample, but note that a RadioButton would usually
// be part of a higher level component, such as a raw with text, and that component would need
// to provide an appropriate content description. See RadioGroupSample.
    Row(Modifier.selectableGroup()) {
        RadioButton(
            selected = state,
            onClick = { state = true },
            modifier = Modifier.semantics { contentDescription = "Localized Description" }
        )
        RadioButton(
            selected = !state,
            onClick = { state = false },
            modifier = Modifier.semantics { contentDescription = "Localized Description" }
        )
    }
}