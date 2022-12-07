package com.nikhil.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.nikhil.compose.ui.codelab.basic.CodeLabBasic
import com.nikhil.compose.ui.codelab.layout.CodeLabBasicLayout
import com.nikhil.compose.ui.codelab.state.StateCore
import com.nikhil.compose.ui.codelab.state.StateIntro
import com.nikhil.compose.ui.codelab.theme.CodeLabTheme
import com.nikhil.compose.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          // BasicMainContent()
          //MdcExample()
            CodeLabContent()
        }
    }




}

@Composable
fun CodeLabContent() {
//    CodeLabBasic()
//    CodeLabBasicLayout()
//    StateIntro()
//    StateCore()
    CodeLabTheme()
}




















