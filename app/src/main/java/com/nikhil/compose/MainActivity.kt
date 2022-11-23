package com.nikhil.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.nikhil.compose.ui.components.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainContent() {
    /* ComposePOCTheme {
         // A surface container using the 'background' color from the theme
         Surface(
             modifier = Modifier.fillMaxSize(),
             color = MaterialTheme.colors.background
         ) {

         }
     }*/
  //  Greeting("Android")
   // ColumnExample()
    // RowExample()
    //ModifierExample()
    /* val painter = painterResource(id = R.drawable.dragon)
     val contentDescription = "New Dragon image"
     val title = "Dragon"
     ImageCard(painter, contentDescription, title)*/
  // TextStyleExample()
   //  ComposeStateExample()
  //  SnackbarExample()
   // ListExample()
    //ConstrainLayoutExample()
    //EffectHandlerExample()
   // AnimationExample()
   // CircularProgressExample(0.8f,300)
    MusicKnobExample()
}



















