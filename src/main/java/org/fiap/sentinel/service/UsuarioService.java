package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.Usuario;

import java.util.List;

@ApplicationScoped
public class UsuarioService {

    @Transactional
    public List<Usuario> listarUsuarios() {
        return Usuario.listAll();
    }

    @Transactional
    public Usuario buscarPorId(Long id) {
        return Usuario.findById(id);
    }

    @Transactional
    public Usuario buscarPorEmail(String email) {
        return Usuario.find("email", email).firstResult();
    }

    @Transactional
    public List<Usuario> buscarPorNome(String nome) {
        return Usuario.find("nome", nome).list();
    }

    @Transactional
    public void criarUsuario(Usuario usuario) {
        usuario.persist();
    }

    @Transactional
    public void atualizarUsuario(Usuario usuario) {
        Usuario.update("nome = ?1, email = ?2, senha = ?3 where id = ?4",
                usuario.nome, usuario.email, usuario.senha, usuario.id);
    }

    @Transactional
    public void deletarUsuario(Long id) {
        Usuario.deleteById(id);
    }
} 