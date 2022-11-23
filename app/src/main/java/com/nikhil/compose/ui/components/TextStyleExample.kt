package com.nikhil.compose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.nikhil.compose.R


@Composable
fun TextStyleExample() {
    val latoFamily = FontFamily(
        Font(R.font.lato_black, FontWeight.Black),
        Font(R.font.lato_black_italic, FontWeight.W400),
        Font(R.font.lato_bold, FontWeight.Bold),
        Font(R.font.lato_bold_italic, FontWeight.SemiBold),
        Font(R.font.lato_regular, FontWeight.Normal),
        Font(R.font.lato_italic, FontWeight.W600),
        Font(R.font.lato_light, FontWeight.Light),
        Font(R.font.lato_light_italic, FontWeight.ExtraLight),
        Font(R.font.lato_thin, FontWeight.Thin),
        Font(R.font.lato_thin_italic, FontWeight.Thin)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold
                    )
                ){
                    append("J")
                }
                append("etpack")
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold
                    )
                ){
                    append("C")
                }
                append("ompose")
            },
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = latoFamily,
            fontWeight = FontWeight.Black,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline

        )
    }

}