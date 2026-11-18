package br.com.fiap.zelaai.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.fiap.zelaai.model.Chamado

@Composable
fun FotoChamado(
    chamado: Chamado,
    modifier: Modifier = Modifier,
    cantos: Dp = 16.dp
) {
    Image(
        painter = painterResource(id = chamado.imagem),
        contentDescription = "Foto do chamado: ${chamado.titulo}",
        contentScale = ContentScale.Crop,
        modifier = modifier.clip(RoundedCornerShape(cantos))
    )
}
