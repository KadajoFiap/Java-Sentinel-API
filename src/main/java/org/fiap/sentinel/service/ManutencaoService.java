package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.Manutencao;
import java.util.List;

@ApplicationScoped
public class ManutencaoService {
    
    @Transactional
    public void registrarManutencao(Manutencao manutencao) {
        if (manutencao == null) {
            throw new IllegalArgumentException("A manutenção não pode ser nula");
        }
        manutencao.persist();
    }

    public Manutencao buscarManutencaoPorId(Long id) {
        return Manutencao.findById(id);
    }

    public List<Manutencao> listarTodasManutencoes() {
        return Manutencao.listAll();
    }

    @Transactional
    public void atualizarManutencao(Manutencao manutencao) {
        if (manutencao == null) {
            throw new IllegalArgumentException("A manutenção não pode ser nula");
        }
        Manutencao manutencaoExistente = Manutencao.findById(manutencao.id);
        if (manutencaoExistente == null) {
            throw new IllegalArgumentException("Manutenção não encontrada");
        }
        manutencao.persist();
    }

    @Transactional
    public void deletarManutencao(Long id) {
        Manutencao.deleteById(id);
    }
} 