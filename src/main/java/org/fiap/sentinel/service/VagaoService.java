package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.Vagao;
import java.util.List;

@ApplicationScoped
public class VagaoService {
    
    @Transactional
    public void registrarVagao(Vagao vagao) {
        if (vagao == null) {
            throw new IllegalArgumentException("O vagão não pode ser nulo");
        }
        vagao.persist();
    }

    public Vagao buscarVagaoPorNumero(Integer numero) {
        return Vagao.find("numero", numero).firstResult();
    }

    public List<Vagao> listarTodosVagoes() {
        return Vagao.listAll();
    }

    @Transactional
    public void atualizarVagao(Vagao vagao) {
        if (vagao == null) {
            throw new IllegalArgumentException("O vagão não pode ser nulo");
        }
        vagao.persist();
    }

    @Transactional
    public void deletarVagao(Integer numero) {
        Vagao.delete("numero", numero);
    }
} 