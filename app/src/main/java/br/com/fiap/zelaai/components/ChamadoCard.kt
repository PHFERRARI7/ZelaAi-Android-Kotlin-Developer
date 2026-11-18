package br.com.fiap.zelaai.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import br.com.fiap.zelaai.model.Chamado
import br.com.fiap.zelaai.ui.theme.Borda
import br.com.fiap.zelaai.ui.theme.Espresso
import br.com.fiap.zelaai.ui.theme.EspressoSuave
import br.com.fiap.zelaai.ui.theme.LaranjaEscuro

@Composable
fun ChamadoCard(chamado: Chamado, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Borda),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(verticalAlignment = Alignment.Top) {
                FotoChamado(chamado = chamado, cantos = 16.dp, modifier = Modifier.size(80.dp))
                Spacer(modifier = Modifier.width(14.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = chamado.protocolo,
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = LaranjaEscuro
                        )
                        StatusBadge(status = chamado.status)
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = chamado.titulo,
                        style = MaterialTheme.typography.titleMedium,
                        color = Espresso,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    InfoLinha(icone = Icons.Filled.LocationOn, texto = "${chamado.rua} · ${chamado.bairro}")
                }
            }
            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp), color = Borda)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                InfoLinha(icone = Icons.Filled.Schedule, texto = chamado.dataAbertura)
                InfoLinha(icone = Icons.Filled.Groups, texto = "${chamado.quantidadeRelatos} relatos")
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = chamado.categorias.joinToString(" • ") { it.descricao } + "  ·  CPF ${chamado.cpfMascarado}",
                style = MaterialTheme.typography.labelMedium,
                color = EspressoSuave,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
