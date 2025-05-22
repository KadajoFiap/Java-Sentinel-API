package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.Linha;

import java.util.List;

@ApplicationScoped
public class LinhaService {

    @Transactional
    public List<Linha> listarLinhas() {
        return Linha.listAll();
    }

    @Transactional
    public Linha buscarPorNome(String nome) {
        return Linha.findById(nome);
    }

    @Transactional
    public List<Linha> buscarPorExtensao(double extensao) {
        return Linha.find("extencao", extensao).list();
    }

    @Transactional
    public List<Linha> buscarPorRegiao(String regiao) {
        return Linha.find("regioesPertenc", regiao).list();
    }

    @Transactional
    public void criarLinha(Linha linha) {
        linha.persist();
    }

    @Transactional
    public void atualizarLinha(Linha linha) {
        Linha.update("extencao = ?1, regioesPertenc = ?2 where nome = ?3",
                linha.extencao, linha.regioesPertenc, linha.nome);
    }

    @Transactional
    public void deletarLinha(String nome) {
        Linha.deleteById(nome);
    }
} 