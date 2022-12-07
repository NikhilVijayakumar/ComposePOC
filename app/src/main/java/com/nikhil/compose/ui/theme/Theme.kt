package com.nikhil.compose.ui.theme

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
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


