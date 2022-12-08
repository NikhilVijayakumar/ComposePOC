package com.nikhil.compose.ui.codelab.theme

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nikhil.compose.R
import com.nikhil.compose.ui.codelab.theme.data.Dog
import com.nikhil.compose.ui.theme.WoofTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofScreen() {
    WoofTheme {
        val viewModel:WoofViewModel = viewModel()
        Scaffold(topBar = { WoofTopBar(R.drawable.ic_woof_logo,R.string.woof_app_name)}) {padding->
            WoofList(padding,viewModel.dogList.toList())
        }
    }
}

@Composable
fun WoofList(padding: PaddingValues, dogs: List<Dog> ,modifier: Modifier = Modifier) {
    LazyColumn(contentPadding = padding, modifier = modifier){
        items(dogs){dog->
            WoofItem(dog)

        }
    }


}

@Composable
fun WoofItem(dog: Dog,modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(8.dp).fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.surface)
        ) {
            Image(
                painter = painterResource(id = dog.imageResourceId),
                contentDescription = null,
                modifier = Modifier.padding( 16.dp)
                    .size(64.dp)
                    .clip(RoundedCornerShape(32.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = dog.name),
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(text = stringResource(id =R.string.years_old, dog.age),
                style = MaterialTheme.typography.bodyMedium
                    )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofTopBar(woofAppLogo: Int, woofAppName: Int,modifier: Modifier = Modifier) {
  TopAppBar(
      title = {
          Text(
              text = stringResource(id = woofAppName),
              modifier=Modifier.padding(horizontal = 8.dp),
              style = MaterialTheme.typography.titleLarge
          )
      },
      navigationIcon = {
                       Icon(painter = painterResource(id = woofAppLogo) , contentDescription = null, tint = Color.Unspecified)
      },
      modifier = modifier
  )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL,
    uiMode = UI_MODE_NIGHT_NO,
    name = "WoofScreenLightPreview"
)
@Composable
fun WoofScreenLightPreview() {
    WoofTheme(darkTheme = false) {
        WoofScreen()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL,
    uiMode = UI_MODE_NIGHT_YES,
    name = "WoofScreenDarkPreview"
)
@Composable
fun WoofScreenDarkPreview() {
    WoofTheme(darkTheme = true) {
        WoofScreen()
    }
}
