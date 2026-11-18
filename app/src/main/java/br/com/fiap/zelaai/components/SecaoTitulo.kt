package br.com.fiap.zelaai.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.fiap.zelaai.ui.theme.Espresso
import br.com.fiap.zelaai.ui.theme.EspressoSuave
import br.com.fiap.zelaai.ui.theme.Laranja

@Composable
fun SecaoTitulo(titulo: String, modifier: Modifier = Modifier, subtitulo: String? = null) {
    Row(
        modifier = modifier.padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(4.dp)
                .height(if (subtitulo != null) 38.dp else 22.dp)
                .background(Laranja, RoundedCornerShape(2.dp))
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(text = titulo, style = MaterialTheme.typography.titleLarge, color = Espresso)
            if (subtitulo != null) {
                Text(text = subtitulo, style = MaterialTheme.typography.bodyMedium, color = EspressoSuave)
            }
        }
    }
}
