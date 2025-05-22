package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.Trem;
import java.util.List;

@ApplicationScoped
public class TremService {
    
    @Transactional
    public void registrarTrem(Trem trem) {
        if (trem == null) {
            throw new IllegalArgumentException("Trem não pode ser nulo");
        }
        trem.persist();
    }

    public Trem buscarTremPorId(Integer idTrem) {
        return Trem.findById(idTrem);
    }

    public List<Trem> listarTodosTrens() {
        return Trem.listAll();
    }

    @Transactional
    public void atualizarTrem(Trem trem) {
        if (trem == null) {
            throw new IllegalArgumentException("Trem não pode ser nulo");
        }
        trem.persist();
    }

    @Transactional
    public void deletarTrem(Integer idTrem) {
        Trem.deleteById(idTrem);
    }
} 