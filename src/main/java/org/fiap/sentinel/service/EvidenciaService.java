package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.Evidencia;
import org.fiap.sentinel.model.Ocorrencia;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class EvidenciaService {

    @Transactional
    public List<Evidencia> listarEvidencias() {
        return Evidencia.listAll();
    }

    @Transactional
    public Evidencia buscarPorId(Long id) {
        return Evidencia.findById(id);
    }

    @Transactional
    public List<Evidencia> buscarPorOcorrencia(Ocorrencia ocorrencia) {
        return Evidencia.find("ocorrencia", ocorrencia).list();
    }

    @Transactional
    public List<Evidencia> buscarPorDataUpload(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return Evidencia.find("dataUpload between ?1 and ?2", dataInicio, dataFim).list();
    }

    @Transactional
    public void criarEvidencia(Evidencia evidencia) {
        evidencia.persist();
    }

    @Transactional
    public void atualizarEvidencia(Evidencia evidencia) {
        Evidencia.update("ocorrencia = ?1, s3Key = ?2, descricao = ?3, dataUpload = ?4 where id = ?5",
                evidencia.ocorrencia, evidencia.s3Key, evidencia.descricao, evidencia.dataUpload, evidencia.id);
    }

    @Transactional
    public void deletarEvidencia(Long id) {
        Evidencia.deleteById(id);
    }
} 