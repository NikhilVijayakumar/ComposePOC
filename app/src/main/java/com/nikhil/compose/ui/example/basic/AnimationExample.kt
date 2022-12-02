package com.nikhil.compose.ui.example.basic

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp



@Composable
fun AnimationExample() {
   // TweenAnimationExample()
    SpringAnimationExample()




}

@Composable
fun SpringAnimationExample() {
    var sizeState by remember {
        mutableStateOf(200.dp)
    }
    val size by animateDpAsState(targetValue = sizeState,
        animationSpec = spring(dampingRatio = Spring.DampingRatioHighBouncy, stiffness = Spring.StiffnessMediumLow)
    )
    Box(modifier = Modifier
        .size(size)
        .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Button(onClick = {
                sizeState += 25.dp

            }) {
                Text(text = "Increase")

            }

            Button(onClick = {
                sizeState -= 25.dp

            }) {
                Text(text = "Decrease")

            }
        }
    }

}

@Composable
fun TweenAnimationExample() {

    var sizeState by remember {
        mutableStateOf(200.dp)
    }
    val size by animateDpAsState(targetValue = sizeState,
        animationSpec = tween(durationMillis = 3000, delayMillis = 300, easing = FastOutLinearInEasing)
    )
    Box(modifier = Modifier
        .size(size)
        .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Button(onClick = {
                sizeState += 25.dp

            }) {
                Text(text = "Increase")

            }

            Button(onClick = {
                sizeState -= 25.dp

            }) {
                Text(text = "Decrease")

            }
        }
    }
}
