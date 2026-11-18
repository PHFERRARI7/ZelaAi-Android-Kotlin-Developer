package br.com.fiap.zelaai.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val ZelaColorScheme = lightColorScheme(
    primary = Laranja,
    onPrimary = Color.White,
    primaryContainer = Pessego,
    onPrimaryContainer = Espresso,
    secondary = Espresso,
    onSecondary = Color.White,
    background = Creme,
    onBackground = Espresso,
    surface = Color.White,
    onSurface = Espresso,
    onSurfaceVariant = EspressoSuave,
    outline = Borda
)

@Composable
fun ZelaAiTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = ZelaColorScheme, typography = Typography, content = content)
}
