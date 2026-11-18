package br.com.fiap.zelaai.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.fiap.zelaai.ui.theme.Laranja
import br.com.fiap.zelaai.ui.theme.LaranjaClaro
import br.com.fiap.zelaai.ui.theme.LaranjaEscuro

@Composable
fun ResumoCard(recebidos: Int, emExecucao: Int, resolvidos: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.linearGradient(listOf(LaranjaClaro, Laranja, LaranjaEscuro)))
                .padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color.White, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.PhoneAndroid,
                        contentDescription = null,
                        tint = Laranja,
                        modifier = Modifier.size(18.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "Zeladoria pelo WhatsApp",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Problemas da sua rua enviados ao 156",
                        color = Color.White.copy(alpha = 0.9f),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            Spacer(modifier = Modifier.height(18.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ResumoIndicador(valor = recebidos, rotulo = "Recebidos", modifier = Modifier.weight(1f))
                ResumoIndicador(valor = emExecucao, rotulo = "Em execução", modifier = Modifier.weight(1f))
                ResumoIndicador(valor = resolvidos, rotulo = "Resolvidos", modifier = Modifier.weight(1f), destaque = true)
            }
        }
    }
}

@Composable
private fun ResumoIndicador(valor: Int, rotulo: String, modifier: Modifier = Modifier, destaque: Boolean = false) {
    Column(
        modifier = modifier
            .background(
                if (destaque) Color.White else Color.White.copy(alpha = 0.22f),
                RoundedCornerShape(18.dp)
            )
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = valor.toString(),
            color = if (destaque) Laranja else Color.White,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = rotulo,
            color = if (destaque) LaranjaEscuro else Color.White,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}
