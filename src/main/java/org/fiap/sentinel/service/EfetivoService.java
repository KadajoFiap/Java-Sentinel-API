package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.Efetivo;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class EfetivoService {

    @Transactional
    public List<Efetivo> listarEfetivos() {
        return Efetivo.listAll();
    }

    @Transactional
    public Efetivo buscarPorId(Long id) {
        return Efetivo.findById(id);
    }

    @Transactional
    public List<Efetivo> buscarPorCpf(String cpf) {
        return Efetivo.find("cpfEfetivo", cpf).list();
    }

    @Transactional
    public List<Efetivo> buscarPorCtps(String ctps) {
        return Efetivo.find("ctps", ctps).list();
    }

    @Transactional
    public List<Efetivo> buscarPorDataRegistro(LocalDate dataRegistro) {
        return Efetivo.find("dataRegistro", dataRegistro).list();
    }

    @Transactional
    public void criarEfetivo(Efetivo efetivo) {
        efetivo.persist();
    }

    @Transactional
    public void atualizarEfetivo(Efetivo efetivo) {
        Efetivo.update("ctps = ?1, cpfEfetivo = ?2, dataRegistro = ?3 where id = ?4",
                efetivo.ctps, efetivo.cpfEfetivo, efetivo.dataRegistro, efetivo.id);
    }

    @Transactional
    public void deletarEfetivo(Long id) {
        Efetivo.deleteById(id);
    }
} 