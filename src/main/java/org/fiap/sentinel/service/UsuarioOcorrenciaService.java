package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.UsuarioOcorrencia;
import org.fiap.sentinel.model.Usuario;
import org.fiap.sentinel.model.Ocorrencia;
import org.fiap.sentinel.model.UsuarioOcorrenciaId;

import java.util.List;

@ApplicationScoped
public class UsuarioOcorrenciaService {

    @Transactional
    public List<UsuarioOcorrencia> listarUsuarioOcorrencias() {
        return UsuarioOcorrencia.listAll();
    }

    @Transactional
    public UsuarioOcorrencia buscarPorId(Long usuarioId, Long ocorrenciaId) {
        return UsuarioOcorrencia.findById(new UsuarioOcorrenciaId(usuarioId, ocorrenciaId));
    }

    @Transactional
    public List<UsuarioOcorrencia> buscarPorUsuario(Usuario usuario) {
        return UsuarioOcorrencia.find("usuario", usuario).list();
    }

    @Transactional
    public List<UsuarioOcorrencia> buscarPorOcorrencia(Ocorrencia ocorrencia) {
        return UsuarioOcorrencia.find("ocorrencia", ocorrencia).list();
    }

    @Transactional
    public void criarUsuarioOcorrencia(UsuarioOcorrencia usuarioOcorrencia) {
        usuarioOcorrencia.persist();
    }

    @Transactional
    public void atualizarUsuarioOcorrencia(UsuarioOcorrencia usuarioOcorrencia) {
        UsuarioOcorrencia.update("usuario = ?1, ocorrencia = ?2 where usuario.id = ?3 and ocorrencia.id = ?4",
                usuarioOcorrencia.usuario, usuarioOcorrencia.ocorrencia, 
                usuarioOcorrencia.usuario.id, usuarioOcorrencia.ocorrencia.id);
    }

    @Transactional
    public void deletarUsuarioOcorrencia(Long usuarioId, Long ocorrenciaId) {
        UsuarioOcorrencia.delete("usuario.id = ?1 and ocorrencia.id = ?2", usuarioId, ocorrenciaId);
    }
} 