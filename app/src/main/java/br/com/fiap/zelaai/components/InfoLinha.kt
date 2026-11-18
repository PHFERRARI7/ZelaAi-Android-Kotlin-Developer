package br.com.fiap.zelaai.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import br.com.fiap.zelaai.ui.theme.EspressoSuave

@Composable
fun InfoLinha(
    icone: ImageVector,
    texto: String,
    modifier: Modifier = Modifier,
    cor: Color = EspressoSuave
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = icone, contentDescription = null, tint = cor, modifier = Modifier.size(14.dp))
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = texto,
            style = MaterialTheme.typography.bodyMedium,
            color = cor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
