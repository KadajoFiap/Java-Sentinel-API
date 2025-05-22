package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.EstacaoLinha;
import org.fiap.sentinel.model.Estacao;
import org.fiap.sentinel.model.Linha;
import org.fiap.sentinel.model.EstacaoLinhaId;

import java.util.List;

@ApplicationScoped
public class EstacaoLinhaService {

    @Transactional
    public List<EstacaoLinha> listarEstacaoLinhas() {
        return EstacaoLinha.listAll();
    }

    @Transactional
    public EstacaoLinha buscarPorId(Long estacaoId, Long linhaId) {
        return EstacaoLinha.findById(new EstacaoLinhaId(estacaoId, linhaId));
    }

    @Transactional
    public List<EstacaoLinha> buscarPorEstacao(Estacao estacao) {
        return EstacaoLinha.find("estacao", estacao).list();
    }

    @Transactional
    public List<EstacaoLinha> buscarPorLinha(Linha linha) {
        return EstacaoLinha.find("linha", linha).list();
    }

    @Transactional
    public void criarEstacaoLinha(EstacaoLinha estacaoLinha) {
        estacaoLinha.persist();
    }

    @Transactional
    public void atualizarEstacaoLinha(EstacaoLinha estacaoLinha) {
        EstacaoLinha.update("estacao = ?1, linha = ?2 where estacao.id = ?3 and linha.id = ?4",
                estacaoLinha.estacao, estacaoLinha.linha,
                estacaoLinha.estacao.id, estacaoLinha.linha.id);
    }

    @Transactional
    public void deletarEstacaoLinha(Long estacaoId, Long linhaId) {
        EstacaoLinha.delete("estacao.id = ?1 and linha.id = ?2", estacaoId, linhaId);
    }
} 