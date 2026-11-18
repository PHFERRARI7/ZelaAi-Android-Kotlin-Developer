package br.com.fiap.zelaai.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.zelaai.components.CategoriaList
import br.com.fiap.zelaai.components.ChamadoCard
import br.com.fiap.zelaai.components.DestaqueList
import br.com.fiap.zelaai.components.ResumoCard
import br.com.fiap.zelaai.components.SecaoTitulo
import br.com.fiap.zelaai.model.Categoria
import br.com.fiap.zelaai.model.StatusChamado
import br.com.fiap.zelaai.repository.ChamadoRepository
import br.com.fiap.zelaai.ui.theme.Creme
import br.com.fiap.zelaai.ui.theme.Espresso
import br.com.fiap.zelaai.ui.theme.EspressoSuave
import br.com.fiap.zelaai.ui.theme.Laranja
import br.com.fiap.zelaai.ui.theme.ZelaAiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val repository = remember { ChamadoRepository() }

    var categoriaSelecionada by remember { mutableStateOf<Categoria?>(null) }

    val chamados = repository.getChamadosPorCategoria(categoriaSelecionada)
    val destaques = remember { repository.getDestaques() }
    val categorias = remember { repository.getCategorias() }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Creme,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(SpanStyle(color = Espresso)) { append("Zela ") }
                                withStyle(SpanStyle(color = Laranja)) { append("Aí") }
                            },
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Text(
                            text = "Zeladoria urbana · São Paulo",
                            style = MaterialTheme.typography.labelMedium,
                            color = EspressoSuave
                        )
                    }
                },
                navigationIcon = {
                    Box(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 10.dp)
                            .size(40.dp)
                            .background(Laranja, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.LocationOn,
                            contentDescription = "Logo Zela Aí",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Creme)
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(top = 8.dp, bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            item {
                ResumoCard(
                    recebidos = repository.contarPorStatus(StatusChamado.RECEBIDO),
                    emExecucao = repository.contarPorStatus(StatusChamado.EM_EXECUCAO),
                    resolvidos = repository.contarPorStatus(StatusChamado.RESOLVIDO)
                )
            }

            item {
                Column {
                    SecaoTitulo(titulo = "Em destaque", subtitulo = "Chamados com maior impacto na mobilidade")
                    Spacer(modifier = Modifier.height(12.dp))
                    DestaqueList(destaques = destaques)
                }
            }

            item {
                Column {
                    SecaoTitulo(titulo = "Categorias")
                    Spacer(modifier = Modifier.height(12.dp))
                    CategoriaList(
                        categorias = categorias,
                        categoriaSelecionada = categoriaSelecionada,
                        onCategoriaSelecionada = { categoriaSelecionada = it }
                    )
                }
            }

            item {
                SecaoTitulo(
                    titulo = "Chamados no seu bairro",
                    subtitulo = "${chamados.size} registro(s) · " +
                        (categoriaSelecionada?.descricao ?: "Todas as categorias")
                )
            }

            items(chamados, key = { it.protocolo }) { chamado ->
                ChamadoCard(chamado = chamado, modifier = Modifier.padding(horizontal = 20.dp))
            }

            if (chamados.isEmpty()) {
                item { ListaVazia() }
            }
        }
    }
}

@Composable
private fun ListaVazia() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Filled.SearchOff,
            contentDescription = null,
            tint = Laranja,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Nenhum chamado nesta categoria.", color = EspressoSuave)
    }
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFFFF6EE)
@Composable
private fun HomeScreenPreview() {
    ZelaAiTheme {
        HomeScreen()
    }
}
