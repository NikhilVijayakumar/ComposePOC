package com.nikhil.compose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ConstrainLayoutExample() {


    val constrain = ConstraintSet{
        val greenBox = createRefFor("greenbox")
        val redBox = createRefFor("redBox")
        constrain(greenBox){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(redBox){
            top.linkTo(greenBox.bottom)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        createVerticalChain(greenBox,redBox, chainStyle = ChainStyle.Spread)


        }
    ConstraintLayout(constraintSet = constrain, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .padding(20.dp)
            .background(Color.Green)
            .layoutId("greenbox"))

        Box(modifier = Modifier
            .padding(20.dp)
            .background(Color.Red)
            .layoutId("redBox"))
    }



}