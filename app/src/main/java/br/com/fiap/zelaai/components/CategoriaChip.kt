package br.com.fiap.zelaai.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.fiap.zelaai.model.Categoria
import br.com.fiap.zelaai.ui.theme.Borda
import br.com.fiap.zelaai.ui.theme.Espresso
import br.com.fiap.zelaai.ui.theme.Laranja

@Composable
fun CategoriaChip(
    texto: String,
    icone: ImageVector,
    selecionado: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(50),
        colors = CardDefaults.cardColors(containerColor = if (selecionado) Laranja else Color.White),
        border = BorderStroke(1.dp, if (selecionado) Laranja else Borda),
        elevation = CardDefaults.cardElevation(defaultElevation = if (selecionado) 4.dp else 0.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 9.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icone,
                contentDescription = null,
                tint = if (selecionado) Color.White else Laranja,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = texto,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = if (selecionado) FontWeight.Bold else FontWeight.Medium,
                color = if (selecionado) Color.White else Espresso
            )
        }
    }
}

@Composable
fun CategoriaList(
    categorias: List<Categoria>,
    categoriaSelecionada: Categoria?,
    onCategoriaSelecionada: (Categoria?) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            CategoriaChip(
                texto = "Todas",
                icone = Icons.Filled.Apps,
                selecionado = categoriaSelecionada == null,
                onClick = { onCategoriaSelecionada(null) }
            )
        }
        items(categorias) { categoria ->
            CategoriaChip(
                texto = categoria.descricao,
                icone = categoria.icone,
                selecionado = categoria == categoriaSelecionada,
                onClick = { onCategoriaSelecionada(categoria) }
            )
        }
    }
}
