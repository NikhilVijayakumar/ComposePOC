package com.nikhil.compose.ui.codelab.theme

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.nikhil.compose.ui.codelab.theme.data.Post
import com.nikhil.compose.ui.codelab.theme.data.PostRepo


class NewsViewModel : ViewModel() {


    private val _postList = PostRepo.getPosts().toMutableStateList()
    val postList: SnapshotStateList<Post> = _postList


    private val _featuredPost = mutableStateOf<Post>(PostRepo.getFeaturedPost())
    val featuredPost: State<Post?> = _featuredPost


}