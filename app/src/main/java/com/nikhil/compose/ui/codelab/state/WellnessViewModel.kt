package com.nikhil.compose.ui.codelab.state

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.nikhil.compose.ui.codelab.state.model.WellnessTask


class WellnessViewModel : ViewModel() {


    private var _count = mutableStateOf<Int>(0)
    val count: State<Int> = _count

    private val _wellnessTasks = getWellnessList().toMutableStateList()
    val wellnessTasks = _wellnessTasks

    fun removeTask(task: WellnessTask) {
        _wellnessTasks.remove(task)
    }

    fun incrementWaterCount() {
        _count.value++
    }

    fun updateTask(task: WellnessTask, isChecked: Boolean) {
        _wellnessTasks.find {
            it.id == task.id
        }?.let { task ->
            task.isChecked = isChecked

        }
    }

    fun getWellnessList() = List(30) {
        WellnessTask(it, "Task$it")
    }
}
