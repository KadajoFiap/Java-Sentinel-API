package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.VagaoCarro;
import org.fiap.sentinel.model.Trem;

import java.util.List;

@ApplicationScoped
public class VagaoCarroService {

    @Transactional
    public List<VagaoCarro> listarVagaoCarros() {
        return VagaoCarro.listAll();
    }

    @Transactional
    public VagaoCarro buscarPorId(Long id) {
        return VagaoCarro.findById(id);
    }

    @Transactional
    public List<VagaoCarro> buscarPorTrem(Trem trem) {
        return VagaoCarro.find("trem", trem).list();
    }

    @Transactional
    public List<VagaoCarro> buscarPorTipo(String tipo) {
        return VagaoCarro.find("tipo", tipo).list();
    }

    @Transactional
    public void criarVagaoCarro(VagaoCarro vagaoCarro) {
        vagaoCarro.persist();
    }

    @Transactional
    public void atualizarVagaoCarro(VagaoCarro vagaoCarro) {
        VagaoCarro.update("trem = ?1 where id = ?2",
                vagaoCarro.trem, vagaoCarro.id);
    }

    @Transactional
    public void deletarVagaoCarro(Long id) {
        VagaoCarro.deleteById(id);
    }
} 