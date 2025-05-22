package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.Tercerizado;

import java.util.List;

@ApplicationScoped
public class TercerizadoService {

    @Transactional
    public List<Tercerizado> listarTercerizados() {
        return Tercerizado.listAll();
    }

    @Transactional
    public Tercerizado buscarPorId(Long id) {
        return Tercerizado.findById(id);
    }

    @Transactional
    public List<Tercerizado> buscarPorEmpresa(String empresa) {
        return Tercerizado.find("empresa", empresa).list();
    }

    @Transactional
    public void criarTercerizado(Tercerizado tercerizado) {
        tercerizado.persist();
    }

    @Transactional
    public void atualizarTercerizado(Tercerizado tercerizado) {
        Tercerizado.update("empresa = ?1, dataContrato = ?2 where id = ?3",
                tercerizado.empresa, tercerizado.dataContrato, tercerizado.id);
    }

    @Transactional
    public void deletarTercerizado(Long id) {
        Tercerizado.deleteById(id);
    }
} 