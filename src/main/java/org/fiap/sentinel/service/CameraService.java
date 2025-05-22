package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.Camera;
import org.fiap.sentinel.model.VagaoCarro;

import java.util.List;

@ApplicationScoped
public class CameraService {

    @Transactional
    public List<Camera> listarCameras() {
        return Camera.listAll();
    }

    @Transactional
    public Camera buscarPorId(Long id) {
        return Camera.findById(id);
    }

    @Transactional
    public List<Camera> buscarPorModelo(String modelo) {
        return Camera.find("modeloCamera", modelo).list();
    }

    @Transactional
    public List<Camera> buscarPorResolucao(String resolucao) {
        return Camera.find("resolucaoCamera", resolucao).list();
    }

    @Transactional
    public List<Camera> buscarPorVagaoCarro(VagaoCarro vagaoCarro) {
        return Camera.find("vagaoCarro", vagaoCarro).list();
    }

    @Transactional
    public void criarCamera(Camera camera) {
        camera.persist();
    }

    @Transactional
    public void atualizarCamera(Camera camera) {
        Camera.update("modeloCamera = ?1, resolucaoCamera = ?2, posicaoNoVagao = ?3, vagaoCarro = ?4 where id = ?5",
                camera.modeloCamera, camera.resolucaoCamera, camera.posicaoNoVagao, camera.vagaoCarro, camera.id);
    }

    @Transactional
    public void deletarCamera(Long id) {
        Camera.deleteById(id);
    }
} 