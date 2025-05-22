package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.Cargo;

import java.util.List;

@ApplicationScoped
public class CargoService {

    @Transactional
    public List<Cargo> listarCargos() {
        return Cargo.listAll();
    }

    @Transactional
    public Cargo buscarPorId(Long id) {
        return Cargo.findById(id);
    }

    @Transactional
    public List<Cargo> buscarPorNome(String nome) {
        return Cargo.find("nomeCargo", nome).list();
    }

    @Transactional
    public List<Cargo> buscarPorSalarioBase(double salarioBase) {
        return Cargo.find("salarioBase", salarioBase).list();
    }

    @Transactional
    public void criarCargo(Cargo cargo) {
        cargo.persist();
    }

    @Transactional
    public void atualizarCargo(Cargo cargo) {
        Cargo.update("nomeCargo = ?1, salarioBase = ?2 where id = ?3",
                cargo.nomeCargo, cargo.salarioBase, cargo.id);
    }

    @Transactional
    public void deletarCargo(Long id) {
        Cargo.deleteById(id);
    }
} 