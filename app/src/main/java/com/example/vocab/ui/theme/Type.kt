package com.example.vocab.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.vocab.R

// Set of Material typography styles to start with

val Inter =  FontFamily(Font(R.font.inter_black))



val Typography = Typography(
    headlineLarge = TextStyle(
        fontSize = 64.sp,
        fontFamily = Inter,
        fontWeight = FontWeight(700),
        color = Color(0xFF1C913D),
        textAlign = TextAlign.Center
),
    displaySmall = TextStyle(
        fontSize = 16.sp,
        fontFamily = Inter,
        fontWeight = FontWeight(700),
        color = Color(0xFF161515),
        textAlign = TextAlign.Center,
    ),
    bodySmall = TextStyle(
    fontSize = 30.sp,
    fontFamily = Inter,
    fontWeight = FontWeight(700),
    color = Color(0xFF000000),
    textAlign = TextAlign.Center,
    ),
    labelMedium = TextStyle(
        fontSize = 24.sp,
        fontFamily = Inter,
        fontWeight = FontWeight(400),
        color = Color(0xFF000000),
        textAlign = TextAlign.Center,
    ),
    bodyLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)
