package com.nikhil.compose.ui.example.mdc

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun LinearProgressIndicatorExample() {


            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                LinearProgressIndicator(
                    modifier = Modifier.semantics(mergeDescendants = true) {}.padding(10.dp)
                )
            }

}