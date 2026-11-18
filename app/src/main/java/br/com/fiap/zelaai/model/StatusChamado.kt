package br.com.fiap.zelaai.model

enum class StatusChamado(val descricao: String) {
    RECEBIDO("Recebido"),
    EM_ANALISE("Em análise"),
    EM_EXECUCAO("Em execução"),
    RESOLVIDO("Resolvido")
}
