package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.Funcionario;
import java.util.List;

@ApplicationScoped
public class FuncionarioService {

    @Transactional
    public void registrarFuncionario(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("O funcionário não pode ser nulo");
        }
        funcionario.persist();
    }

    public Funcionario buscarFuncionarioPorCpf(String cpf) {
        return Funcionario.find("cpf", cpf).firstResult();
    }

    public List<Funcionario> listarTodosFuncionarios() {
        return Funcionario.listAll();
    }

    @Transactional
    public void atualizarFuncionario(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("O funcionário não pode ser nulo");
        }
        funcionario.persist();
    }

    @Transactional
    public void deletarFuncionario(String cpf) {
        Funcionario.delete("cpf", cpf);
    }
} 