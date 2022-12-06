package com.nikhil.compose.ui.codelab.state.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class WellnessTask(val id: Int, val label: String, initialChecked:Boolean = false){
    var isChecked by mutableStateOf(initialChecked)
}