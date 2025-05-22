package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.Ocorrencia;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class OcorrenciaService {
    
    @Transactional
    public void registrarOcorrencia(Ocorrencia ocorrencia) {
        if (ocorrencia == null) {
            throw new IllegalArgumentException("Ocorrência não pode ser nula");
        }
        ocorrencia.persist();
    }

    public Ocorrencia buscarOcorrenciaPorDescricao(String descricao) {
        return Ocorrencia.find("descricao", descricao).firstResult();
    }

    public List<Ocorrencia> listarTodasOcorrencias() {
        return Ocorrencia.listAll();
    }

    @Transactional
    public void atualizarOcorrencia(Ocorrencia ocorrencia) {
        if (ocorrencia == null) {
            throw new IllegalArgumentException("Ocorrência não pode ser nula");
        }
        ocorrencia.persist();
    }

    @Transactional
    public void deletarOcorrencia(String descricao) {
        Ocorrencia.delete("descricao", descricao);
    }

    public List<Ocorrencia> buscarOcorrenciasPorTremEPeriodo(String numeroTrem, LocalDateTime dataInicio, LocalDateTime dataFim) {
        return Ocorrencia.find("numeroTrem = ?1 and dataHora between ?2 and ?3", 
            numeroTrem, dataInicio, dataFim).list();
    }

    public List<Ocorrencia> buscarOcorrenciasCriticas() {
        return Ocorrencia.find("severidade >= ?1", 8).list();
    }

    public String classificarUrgencia(Ocorrencia ocorrencia) {
        if (ocorrencia == null) {
            throw new IllegalArgumentException("A ocorrência não pode ser nula");
        }
        
        int severidade = ocorrencia.severidadeOcorrencia;
        if (severidade >= 8) {
            return "CRÍTICA";
        } else if (severidade >= 5) {
            return "ALTA";
        } else if (severidade >= 3) {
            return "MÉDIA";
        } else {
            return "BAIXA";
        }
    }
} 