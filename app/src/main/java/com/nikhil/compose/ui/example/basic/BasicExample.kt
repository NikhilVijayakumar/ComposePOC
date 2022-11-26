package com.nikhil.compose.ui.example

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ModifierExample() {
    Column(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth(0.7f)
            .fillMaxHeight(0.7f)
    ) {
        Text(text = "Hello")
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = "Android")
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = "Kotlin")
    }
}

@Composable
fun RowExample() {
    Row(
        Modifier
            .fillMaxWidth(0.8f)
            .fillMaxHeight()
            .background(Color.Blue),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        Text(text = "Hello")
        Text(text = "Android")
        Text(text = "Kotlin")
    }

}

@Composable
fun ColumnExample() {
    Column(
        Modifier
            .fillMaxHeight(0.8f)
            .fillMaxWidth()
            .background(Color.Blue),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello")
        Text(text = "Android")
        Text(text = "Kotlin")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}