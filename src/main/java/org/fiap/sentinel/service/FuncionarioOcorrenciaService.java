package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.FuncionarioOcorrencia;
import org.fiap.sentinel.model.Funcionario;
import org.fiap.sentinel.model.Ocorrencia;
import org.fiap.sentinel.model.FuncionarioOcorrenciaId;

import java.util.List;

@ApplicationScoped
public class FuncionarioOcorrenciaService {

    @Transactional
    public List<FuncionarioOcorrencia> listarFuncionarioOcorrencias() {
        return FuncionarioOcorrencia.listAll();
    }

    @Transactional
    public FuncionarioOcorrencia buscarPorId(Long funcionarioId, Long ocorrenciaId) {
        return FuncionarioOcorrencia.findById(new FuncionarioOcorrenciaId(funcionarioId, ocorrenciaId));
    }

    @Transactional
    public List<FuncionarioOcorrencia> buscarPorFuncionario(Funcionario funcionario) {
        return FuncionarioOcorrencia.find("funcionario", funcionario).list();
    }

    @Transactional
    public List<FuncionarioOcorrencia> buscarPorOcorrencia(Ocorrencia ocorrencia) {
        return FuncionarioOcorrencia.find("ocorrencia", ocorrencia).list();
    }

    @Transactional
    public void criarFuncionarioOcorrencia(FuncionarioOcorrencia funcionarioOcorrencia) {
        funcionarioOcorrencia.persist();
    }

    @Transactional
    public void atualizarFuncionarioOcorrencia(FuncionarioOcorrencia funcionarioOcorrencia) {
        FuncionarioOcorrencia.update("funcionario = ?1, ocorrencia = ?2 where funcionario.id = ?3 and ocorrencia.id = ?4",
                funcionarioOcorrencia.funcionario, funcionarioOcorrencia.ocorrencia,
                funcionarioOcorrencia.funcionario.id, funcionarioOcorrencia.ocorrencia.id);
    }

    @Transactional
    public void deletarFuncionarioOcorrencia(Long funcionarioId, Long ocorrenciaId) {
        FuncionarioOcorrencia.delete("funcionario.id = ?1 and ocorrencia.id = ?2", funcionarioId, ocorrenciaId);
    }
} 