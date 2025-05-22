package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.Infrator;
import java.util.List;

@ApplicationScoped
public class InfratorService {
    
    @Transactional
    public void registrarInfrator(Infrator infrator) {
        if (infrator == null) {
            throw new IllegalArgumentException("O infrator não pode ser nulo");
        }
        infrator.persist();
    }

    public Infrator buscarInfratorPorCpf(String cpf) {
        return Infrator.find("cpf", cpf).firstResult();
    }

    public List<Infrator> listarTodosInfratores() {
        return Infrator.listAll();
    }

    @Transactional
    public void atualizarInfrator(Infrator infrator) {
        if (infrator == null) {
            throw new IllegalArgumentException("O infrator não pode ser nulo");
        }
        infrator.persist();
    }

    @Transactional
    public void deletarInfrator(String cpf) {
        Infrator.delete("cpf", cpf);
    }
} 