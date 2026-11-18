package br.com.fiap.zelaai.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Park
import androidx.compose.material.icons.filled.Traffic
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.fiap.zelaai.model.Categoria
import br.com.fiap.zelaai.model.StatusChamado
import br.com.fiap.zelaai.ui.theme.StatusAnalise
import br.com.fiap.zelaai.ui.theme.StatusExecucao
import br.com.fiap.zelaai.ui.theme.StatusRecebido
import br.com.fiap.zelaai.ui.theme.StatusResolvido

val Categoria.icone: ImageVector
    get() = when (this) {
        Categoria.BURACO -> Icons.Filled.Construction
        Categoria.CALCADA -> Icons.AutoMirrored.Filled.DirectionsWalk
        Categoria.ILUMINACAO -> Icons.Filled.Lightbulb
        Categoria.ACESSIBILIDADE -> Icons.Filled.Accessibility
        Categoria.LIXO -> Icons.Filled.Delete
        Categoria.SINALIZACAO -> Icons.Filled.Traffic
        Categoria.ARVORE -> Icons.Filled.Park
    }

val StatusChamado.cor: Color
    get() = when (this) {
        StatusChamado.RECEBIDO -> StatusRecebido
        StatusChamado.EM_ANALISE -> StatusAnalise
        StatusChamado.EM_EXECUCAO -> StatusExecucao
        StatusChamado.RESOLVIDO -> StatusResolvido
    }
