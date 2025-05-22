package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.Estacao;

import java.util.List;

@ApplicationScoped
public class EstacaoService {

    @Transactional
    public List<Estacao> listarEstacoes() {
        return Estacao.listAll();
    }

    @Transactional
    public Estacao buscarPorId(Long id) {
        return Estacao.findById(id);
    }

    @Transactional
    public List<Estacao> buscarPorNome(String nome) {
        return Estacao.find("nomeEstacao", nome).list();
    }

    @Transactional
    public List<Estacao> buscarPorNumeroPlataformas(int numeroPlataformas) {
        return Estacao.find("nrPlataformas", numeroPlataformas).list();
    }

    @Transactional
    public void criarEstacao(Estacao estacao) {
        estacao.persist();
    }

    @Transactional
    public void atualizarEstacao(Estacao estacao) {
        Estacao.update("nomeEstacao = ?1, nrPlataformas = ?2 where id = ?3",
                estacao.nomeEstacao, estacao.nrPlataformas, estacao.id);
    }

    @Transactional
    public void deletarEstacao(Long id) {
        Estacao.deleteById(id);
    }
} 