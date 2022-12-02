package com.nikhil.compose.ui.example.mdc.loaders

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun LinearProgressIndicatorExample1() {
    val progressBreakpoints = 1..100
    var progress by remember { mutableStateOf(0.1f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LinearProgressIndicator(
            modifier = Modifier.semantics(mergeDescendants = true) {}.padding(10.dp),
            progress = animatedProgress,
        )
        Spacer(Modifier.requiredHeight(30.dp))
        OutlinedButton(
            modifier = Modifier.semantics {
                val progressPercent = (progress * 100).toInt()

                if (progressPercent in progressBreakpoints) {
                    stateDescription = "Progress $progressPercent%"
                }
            },
            onClick = {
                if (progress < 1f) progress += 0.1f
            }
        ) {
            Text("Increase")
        }
    }
}