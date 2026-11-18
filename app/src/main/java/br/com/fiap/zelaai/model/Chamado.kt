package br.com.fiap.zelaai.model

import androidx.annotation.DrawableRes

data class Chamado(
    val protocolo: String,
    val titulo: String,
    val descricao: String,
    val bairro: String,
    val rua: String,
    val dataAbertura: String,
    val status: StatusChamado,
    val prioridade: Int,
    val quantidadeRelatos: Int,
    val cpfMascarado: String,
    @DrawableRes val imagem: Int,
    val categorias: List<Categoria>,
    val destaque: Boolean
)
