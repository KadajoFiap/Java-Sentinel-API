package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.CameraOcorrencia;
import org.fiap.sentinel.model.Camera;
import org.fiap.sentinel.model.Ocorrencia;
import org.fiap.sentinel.model.CameraOcorrenciaId;

import java.util.List;

@ApplicationScoped
public class CameraOcorrenciaService {

    @Transactional
    public List<CameraOcorrencia> listarCameraOcorrencias() {
        return CameraOcorrencia.listAll();
    }

    @Transactional
    public CameraOcorrencia buscarPorId(Long cameraId, Long ocorrenciaId) {
        return CameraOcorrencia.findById(new CameraOcorrenciaId(cameraId, ocorrenciaId));
    }

    @Transactional
    public List<CameraOcorrencia> buscarPorCamera(Camera camera) {
        return CameraOcorrencia.find("camera", camera).list();
    }

    @Transactional
    public List<CameraOcorrencia> buscarPorOcorrencia(Ocorrencia ocorrencia) {
        return CameraOcorrencia.find("ocorrencia", ocorrencia).list();
    }

    @Transactional
    public void criarCameraOcorrencia(CameraOcorrencia cameraOcorrencia) {
        cameraOcorrencia.persist();
    }

    @Transactional
    public void atualizarCameraOcorrencia(CameraOcorrencia cameraOcorrencia) {
        CameraOcorrencia.update("dataCaptura = ?1 where camera.id = ?2 and ocorrencia.id = ?3",
                cameraOcorrencia.dataCaptura, cameraOcorrencia.camera.id, cameraOcorrencia.ocorrencia.id);
    }

    @Transactional
    public void deletarCameraOcorrencia(Long cameraId, Long ocorrenciaId) {
        CameraOcorrencia.delete("camera.id = ?1 and ocorrencia.id = ?2", cameraId, ocorrenciaId);
    }
} 