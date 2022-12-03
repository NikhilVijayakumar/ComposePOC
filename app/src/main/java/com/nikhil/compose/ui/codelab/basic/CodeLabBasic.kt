package com.nikhil.compose.ui.codelab.basic

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikhil.compose.R
import com.nikhil.compose.ui.theme.AppTheme

@Preview(
    name = "Dark preview",
    showBackground = true,
    widthDp = 320,
    heightDp = 480,
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "Light preview",
    showBackground = true,
    widthDp = 320,
    heightDp = 480,
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun CodeLabBasic() {
    AppTheme {
        MyApp(Modifier.fillMaxSize())
    }

}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var showOnboarding by rememberSaveable {
        mutableStateOf(true)
    }
    if (showOnboarding) {
        OnBoardingScreen(modifier
        ) { showOnboarding = !showOnboarding }
    } else {
        GreetingScreen(
            modifier,
            // listOf("Android", "Compose")
            List(1000) { "$it" }
        )
    }
}

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Column(
        modifier = modifier.padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to basic codelab")
        Spacer(modifier = Modifier.padding(8.dp))
        Button(onClick = onClick) {
            Text(text = "Continue")

        }
    }

}

@Composable
fun GreetingScreen(
    modifier: Modifier = Modifier,
    nameList: List<String> = listOf("World", "Compose")
) {

    LazyColumn(modifier = modifier) {
        items(nameList) { name ->
            GreetingCard(name = name)
        }
    }

    /*
    For loop to load list of items without scrolling and lazy
    Column(
         modifier = modifier.padding(vertical = 4.dp),
     ) {
         for (name in nameList) {
             Greeting(name = name)
         }
     }*/

}

@Composable
fun GreetingCard(name: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.primary
        ),
        modifier = Modifier.padding(
            horizontal = 8.dp,
            vertical = 4.dp
        )
    ) {
        GreetingCardItem(name)
    }

}

@Composable
fun GreetingCardItem(name: String) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )

    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .weight(1f)
        ) {
            Text(text = stringResource(R.string.hello))
            Text(text = name)
            if (expanded) {
                Text(
                    text = (stringResource(R.string.expanded)).repeat(4),
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) stringResource(R.string.show_less) else stringResource(
                    R.string.show_more
                )
            )
        }
    }

}

@Composable
private fun Greeting(name: String) {
    var expanded by remember {
        mutableStateOf(false)
    }
    /*
    won't work and crash in show less animation as it goes to negative padding
    val extraPadding by animateDpAsState(
         if (expanded) 48.dp else 0.dp,
         animationSpec = spring(
             dampingRatio = Spring.DampingRatioMediumBouncy,
             stiffness = Spring.StiffnessLow
         )
     )*/
    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp,
        animationSpec = tween(delayMillis = 300, easing = FastOutLinearInEasing)
    )


    Surface(
        color = colorScheme.primary,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello,")
                Text(text = name)
            }
            ElevatedButton(onClick = { expanded = !expanded }) {
                Text(text = if (expanded) "Show less" else "Show more")
            }
        }

    }
}


