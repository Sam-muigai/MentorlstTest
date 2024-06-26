package com.samkt.mentorlsttest.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.samkt.mentorlsttest.R

val poppins =
    FontFamily(
        Font(R.font.poppins_light, FontWeight.Light),
        Font(R.font.poppins_regular, FontWeight.Normal),
        Font(R.font.poppins_medium, FontWeight.Medium),
        Font(R.font.poppins_semibold, FontWeight.SemiBold),
        Font(R.font.poppins_bold, FontWeight.Bold),
    )

val Typography =
    Typography(
        labelLarge =
            TextStyle(
                fontFamily = poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 16.sp,
            ),
        bodyLarge =
            TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 0.28.sp,
                fontFamily = poppins,
            ),
        titleLarge =
            TextStyle(
                fontFamily = poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                lineHeight = 40.sp,
            ),
        displayLarge =
            TextStyle(
                fontFamily = poppins,
                fontWeight = FontWeight.Medium,
                fontSize = 86.sp,
                lineHeight = 100.sp,
            ),
    )
