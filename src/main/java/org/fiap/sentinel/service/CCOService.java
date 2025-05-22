package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.CCO;

import java.util.List;

@ApplicationScoped
public class CCOService {

    @Transactional
    public List<CCO> listarCCOs() {
        return CCO.listAll();
    }

    @Transactional
    public CCO buscarPorId(Long id) {
        return CCO.findById(id);
    }

    @Transactional
    public List<CCO> buscarPorEndereco(String endereco) {
        return CCO.find("enderecoCco", endereco).list();
    }

    @Transactional
    public List<CCO> buscarPorTelefone(String telefone) {
        return CCO.find("telefone", telefone).list();
    }

    @Transactional
    public void criarCCO(CCO cco) {
        cco.persist();
    }

    @Transactional
    public void atualizarCCO(CCO cco) {
        CCO.update("enderecoCco = ?1, telefone = ?2 where id = ?3",
                cco.enderecoCco, cco.telefone, cco.id);
    }

    @Transactional
    public void deletarCCO(Long id) {
        CCO.deleteById(id);
    }
} 