package com.nikhil.compose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun SnackbarExample() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var  textfieldState by remember {
        mutableStateOf("")
    }
    Scaffold(modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState)
    {
        Column(horizontalAlignment =  Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 20.dp)
        ) {
            TextField(value = textfieldState,
                label = {
                    Text(text = "Enter the name")
                },
                onValueChange = {
                    textfieldState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Hello $textfieldState")
                }
            }) {
                Text(text = "Save")
            }
        }

    }

}