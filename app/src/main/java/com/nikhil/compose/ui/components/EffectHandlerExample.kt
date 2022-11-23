package com.nikhil.compose.ui.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch

var effect = 0


@Composable
fun EffectHandlerExample() {
    //LaunchedEffectExample()
    //RememberCouroutineExample()
    //RememberUpdatedStateExample(LaunchedEffectExample())
   // DisposableEffectExample()
   // SideEffectExample()
  //  produceStateExample()
  //  DerivedStateDemo()
    SnapshotFlowExample()
}

@Composable
fun SnapshotFlowExample() {
    val  scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = scaffoldState ){
        snapshotFlow {
            scaffoldState.snackbarHostState
        }.mapNotNull {
            it.currentSnackbarData?.message
        }.distinctUntilChanged()
            .collect{
                println("Snackbar with message $it is shown")
            }
    }

}

@Composable
fun DerivedStateDemo() {
    var counter by remember {
        mutableStateOf(0)
    }
    /* counterText is recalculated each time button is pressed which is bad
    val counterText =
    */

    val counterText:String by derivedStateOf {
        "This counter is $counter"
    }

    Button(onClick = { counter++ }) {
        Text(text = counterText)
    }

}

@Composable
fun produceStateExample(counter:Int):State<Int> {
    /*
    * Similar to the flow emit value over a period of time
    * equvalent flow is given below

    return  flow<Int> {
        var value = 0
    emit(value)
        while (value < counter){
            delay(1000L)
            value++
        }
    }.collectAsState(initial = 0)
    *
    *
     * */
    return produceState(initialValue =counter ){
        while (value < counter){
            delay(1000L)
            value++
        }
    }   
}

@Composable
fun SideEffectExample() {
    /*
    * Get called each time when function is recomposed
    * */
    SideEffect {
        effect++
        println(effect)
    }

}

@Composable
fun DisposableEffectExample() {
    /*
    Memory leak as we are not cleaning the lifecycleOwner and observer and this will called
    each time when this function is recomposed
    val lifecycleOwner = LocalLifecycleOwner.current
    val observer = LifecycleEventObserver{_,event->
        if(event == Lifecycle.Event.ON_PAUSE){
            println("on Pause ()")
        }

    }*/
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_PAUSE) {
                println("on Pause ()")
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }


    //Splash Example
    @Composable
    fun RememberUpdatedStateExample(
        onTimeOut: Unit
    ) {
/*
if onTimeOut function changes it won't get update as key1 is true
    LaunchedEffect(key1 = true ){
        delay(3000)
        onTimeOut
    }
    */
        val updatedTimeOut by rememberUpdatedState(newValue = onTimeOut)
        LaunchedEffect(key1 = true) {
            delay(3000)
            updatedTimeOut
        }

    }

    @Composable
    fun RememberCouroutineExample() {
        val scope = rememberCoroutineScope()
        /*
        Side effect can be used only in places like button click
         scope.launch {

         }
         */
        Button(onClick = {
            scope.launch {
                effect++
                println(effect)
            }
        }) {
            Text(text = "Test")

        }
    }

    @Composable
    fun LaunchedEffectExample() {
        var text by remember {
            mutableStateOf("")
        }
        /*
        side effect example
        Button(onClick = {
            text += "$"
        }) {
            effect++
            Text(text = text)
        }
        */

        Button(onClick = {
            text += "$"
        }) {
            Text(text = text)
            LaunchedEffect(key1 = text) {
                effect++
                println(effect)
            }
        }
    }
}
