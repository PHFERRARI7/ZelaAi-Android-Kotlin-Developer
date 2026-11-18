package br.com.fiap.zelaai.repository

import br.com.fiap.zelaai.R
import br.com.fiap.zelaai.model.Categoria
import br.com.fiap.zelaai.model.Chamado
import br.com.fiap.zelaai.model.StatusChamado

class ChamadoRepository {

    private val chamados = listOf(
        Chamado(
            protocolo = "ZA-2026-000184",
            titulo = "Rampa de acessibilidade quebrada",
            descricao = "Rampa da esquina está rachada e impede a passagem de cadeirantes.",
            bairro = "Vila Mariana",
            rua = "Rua Domingos de Morais, 1200",
            dataAbertura = "10/11/2026 08:42",
            status = StatusChamado.EM_EXECUCAO,
            prioridade = 95,
            quantidadeRelatos = 12,
            cpfMascarado = "***.482.***-**",
            imagem = R.drawable.foto_rampa_acessibilidade,
            categorias = listOf(Categoria.ACESSIBILIDADE, Categoria.CALCADA),
            destaque = true
        ),
        Chamado(
            protocolo = "ZA-2026-000191",
            titulo = "Buraco em frente à escola",
            descricao = "Buraco grande na faixa de pedestres, ao lado da EMEF.",
            bairro = "Itaquera",
            rua = "Av. Jacu-Pêssego, 450",
            dataAbertura = "11/11/2026 07:15",
            status = StatusChamado.EM_ANALISE,
            prioridade = 90,
            quantidadeRelatos = 9,
            cpfMascarado = "***.117.***-**",
            imagem = R.drawable.foto_buraco_escola,
            categorias = listOf(Categoria.BURACO, Categoria.ACESSIBILIDADE),
            destaque = true
        ),
        Chamado(
            protocolo = "ZA-2026-000203",
            titulo = "Poste apagado no ponto de ônibus",
            descricao = "Ponto de ônibus totalmente escuro à noite, trecho inseguro.",
            bairro = "Capão Redondo",
            rua = "Estrada de Itapecerica, 3100",
            dataAbertura = "11/11/2026 21:03",
            status = StatusChamado.RECEBIDO,
            prioridade = 82,
            quantidadeRelatos = 6,
            cpfMascarado = "***.905.***-**",
            imagem = R.drawable.foto_poste_apagado,
            categorias = listOf(Categoria.ILUMINACAO),
            destaque = true
        ),
        Chamado(
            protocolo = "ZA-2026-000156",
            titulo = "Calçada afundada perto do hospital",
            descricao = "Desnível de 10 cm na calçada, risco de queda para idosos.",
            bairro = "Bela Vista",
            rua = "Rua Treze de Maio, 870",
            dataAbertura = "08/11/2026 14:20",
            status = StatusChamado.EM_EXECUCAO,
            prioridade = 88,
            quantidadeRelatos = 7,
            cpfMascarado = "***.330.***-**",
            imagem = R.drawable.foto_calcada_afundada,
            categorias = listOf(Categoria.CALCADA, Categoria.ACESSIBILIDADE),
            destaque = true
        ),
        Chamado(
            protocolo = "ZA-2026-000142",
            titulo = "Entulho descartado na via",
            descricao = "Restos de obra ocupando metade da rua e da calçada.",
            bairro = "Penha",
            rua = "Rua Padre Benedito de Camargo, 95",
            dataAbertura = "06/11/2026 10:05",
            status = StatusChamado.RESOLVIDO,
            prioridade = 60,
            quantidadeRelatos = 3,
            cpfMascarado = "***.761.***-**",
            imagem = R.drawable.foto_entulho_via,
            categorias = listOf(Categoria.LIXO, Categoria.CALCADA),
            destaque = false
        ),
        Chamado(
            protocolo = "ZA-2026-000177",
            titulo = "Semáforo de pedestres sem funcionar",
            descricao = "Botoeira e sinal sonoro para deficientes visuais desligados.",
            bairro = "Pinheiros",
            rua = "Rua dos Pinheiros, 1500",
            dataAbertura = "09/11/2026 17:48",
            status = StatusChamado.EM_ANALISE,
            prioridade = 78,
            quantidadeRelatos = 5,
            cpfMascarado = "***.218.***-**",
            imagem = R.drawable.foto_semaforo_pedestre,
            categorias = listOf(Categoria.SINALIZACAO, Categoria.ACESSIBILIDADE),
            destaque = false
        ),
        Chamado(
            protocolo = "ZA-2026-000168",
            titulo = "Árvore com risco de queda",
            descricao = "Galho grande inclinado sobre a fiação e o ponto de ônibus.",
            bairro = "Santana",
            rua = "Rua Voluntários da Pátria, 2200",
            dataAbertura = "09/11/2026 09:30",
            status = StatusChamado.RECEBIDO,
            prioridade = 74,
            quantidadeRelatos = 4,
            cpfMascarado = "***.653.***-**",
            imagem = R.drawable.foto_arvore_risco,
            categorias = listOf(Categoria.ARVORE),
            destaque = false
        ),
        Chamado(
            protocolo = "ZA-2026-000131",
            titulo = "Buraco recorrente na avenida",
            descricao = "Buraco reaberto após chuva, motos desviando para a calçada.",
            bairro = "Mooca",
            rua = "Rua da Mooca, 3050",
            dataAbertura = "04/11/2026 12:10",
            status = StatusChamado.RESOLVIDO,
            prioridade = 65,
            quantidadeRelatos = 8,
            cpfMascarado = "***.094.***-**",
            imagem = R.drawable.foto_buraco_avenida,
            categorias = listOf(Categoria.BURACO),
            destaque = false
        ),
        Chamado(
            protocolo = "ZA-2026-000199",
            titulo = "Placa de rua derrubada",
            descricao = "Placa com nome da rua caída, dificulta a localização.",
            bairro = "Lapa",
            rua = "Rua Guaicurus, 640",
            dataAbertura = "11/11/2026 11:55",
            status = StatusChamado.RECEBIDO,
            prioridade = 40,
            quantidadeRelatos = 1,
            cpfMascarado = "***.577.***-**",
            imagem = R.drawable.foto_placa_derrubada,
            categorias = listOf(Categoria.SINALIZACAO),
            destaque = false
        ),
        Chamado(
            protocolo = "ZA-2026-000150",
            titulo = "Lâmpadas queimadas na praça",
            descricao = "Três postes da praça apagados há mais de uma semana.",
            bairro = "Tatuapé",
            rua = "Praça Sílvio Romero, s/n",
            dataAbertura = "07/11/2026 19:22",
            status = StatusChamado.EM_EXECUCAO,
            prioridade = 58,
            quantidadeRelatos = 4,
            cpfMascarado = "***.846.***-**",
            imagem = R.drawable.foto_praca_escura,
            categorias = listOf(Categoria.ILUMINACAO, Categoria.ARVORE),
            destaque = false
        )
    )

    fun getChamados(): List<Chamado> = chamados.sortedByDescending { it.prioridade }

    fun getChamadosPorCategoria(categoria: Categoria?): List<Chamado> =
        if (categoria == null) getChamados()
        else getChamados().filter { it.categorias.contains(categoria) }

    fun getDestaques(): List<Chamado> = getChamados().filter { it.destaque }

    fun getCategorias(): List<Categoria> = Categoria.entries

    fun contarPorStatus(status: StatusChamado): Int = chamados.count { it.status == status }
}
