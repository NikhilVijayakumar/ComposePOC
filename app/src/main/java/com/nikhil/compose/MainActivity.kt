package com.nikhil.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nikhil.compose.ui.example.mdc.MdcExample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          // BasicMainContent()
          MdcExample()
        }
    }


}
/*private fun MdcPreview() {
    TODO("Not yet implemented")
}*/




















