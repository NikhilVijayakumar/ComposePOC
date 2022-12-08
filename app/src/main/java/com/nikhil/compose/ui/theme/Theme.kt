package com.nikhil.compose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val LightColors = lightColorScheme(
    primary = Red700,
    primaryContainer = Red900,
    onPrimary = Color.White,
    secondary = Red700,
    secondaryContainer = Red900,
    onSecondary = Color.White,
    error = Red800,
    surface = Red700
)


private val DarkColors = darkColorScheme(
    primary = Red300,
    primaryContainer = Red700,
    onPrimary = Color.Black.copy(alpha = 0.7f),
    secondary = Red300,
    secondaryContainer = Red700,
    onSecondary = Color.Black,
    error = Red200,
    surface = Black200
)

@Composable
fun AppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (useDarkTheme) {
        DarkColors
    } else {
        LightColors
    }

    val systemUiController = rememberSystemUiController()
    if(useDarkTheme){
        systemUiController.setSystemBarsColor(
            color = Color.Black.copy(alpha = 0.9f)
        )
    }else{
        systemUiController.setSystemBarsColor(
            color = Red900
        )
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = CutCornerShape,
        content = content
    )
}

private val LightColorPalette = lightColorScheme(
    background = Green100,
    surface = Green50,
    onSurface = Grey900,
    primary = Grey50,
    onPrimary = Grey900,
    secondary = Grey700
)

private val DarkColorPalette = darkColorScheme(
    background = Cyan900,
    surface = Cyan700,
    onSurface = White,
    primary = Grey900,
    onPrimary = White,
    secondary = Grey100
)

@Composable
fun WoofTheme(darkTheme: Boolean = isSystemInDarkTheme(),
              content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = RoundedShapes,
        content = content
    )

}


