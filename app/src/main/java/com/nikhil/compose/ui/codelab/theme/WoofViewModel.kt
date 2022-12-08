package com.nikhil.compose.ui.codelab.theme

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.nikhil.compose.ui.codelab.theme.data.Dog
import com.nikhil.compose.ui.codelab.theme.data.DogRepo

class WoofViewModel : ViewModel() {

    private val _dogList = DogRepo.getDogs().toMutableStateList()
    val dogList: SnapshotStateList<Dog> = _dogList
}