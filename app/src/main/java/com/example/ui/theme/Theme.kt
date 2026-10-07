package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = RoseCrimson,
    onPrimary = Color.White,
    primaryContainer = RoseBlush,
    onPrimaryContainer = RoseCrimsonDark,
    secondary = RoseCrimsonDark,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFFFE4E6),
    onSecondaryContainer = Color(0xFF4C0519),
    tertiary = RoseGold,
    onTertiary = Color.White,
    background = RoseSurfaceLight,
    onBackground = RoseTextPrimaryLight,
    surface = RoseCardLight,
    onSurface = RoseTextPrimaryLight,
    surfaceVariant = RoseBlush,
    onSurfaceVariant = RoseTextSecondaryLight,
    outline = RoseBorderLight
)

private val DarkColorScheme = darkColorScheme(
    primary = RoseSoft,
    onPrimary = Color(0xFF4C0519),
    primaryContainer = RoseDarkCard,
    onPrimaryContainer = RoseDarkTextSecondary,
    secondary = RoseDarkAccent,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFF4C0519),
    onSecondaryContainer = Color(0xFFFFE4E6),
    tertiary = Color(0xFFFDE68A),
    onTertiary = Color(0xFF451A03),
    background = RoseDarkBackground,
    onBackground = RoseDarkTextPrimary,
    surface = RoseDarkSurface,
    onSurface = RoseDarkTextPrimary,
    surfaceVariant = RoseDarkCard,
    onSurfaceVariant = RoseDarkTextSecondary,
    outline = RoseDarkBorder
)

@Composable
fun DailyRomanticStatusTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Keep bespoke romantic palette by default for strong branding
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
