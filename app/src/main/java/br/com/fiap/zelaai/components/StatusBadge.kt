package br.com.fiap.zelaai.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.fiap.zelaai.model.StatusChamado

@Composable
fun StatusBadge(status: StatusChamado, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(status.cor.copy(alpha = 0.12f), RoundedCornerShape(50))
            .padding(horizontal = 10.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(6.dp)
                .background(status.cor, CircleShape)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = status.descricao,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            color = status.cor
        )
    }
}
