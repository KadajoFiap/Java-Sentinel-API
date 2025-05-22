package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.Usuario;
import org.fiap.sentinel.service.UsuarioService;

import java.util.List;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @GET
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GET
    @Path("/{id}")
    public Response buscarUsuario(@PathParam("id") Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(usuario).build();
    }

    @GET
    @Path("/email/{email}")
    public Response buscarUsuarioPorEmail(@PathParam("email") String email) {
        Usuario usuario = usuarioService.buscarPorEmail(email);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(usuario).build();
    }

    @POST
    @Transactional
    public Response criarUsuario(Usuario usuario) {
        usuarioService.criarUsuario(usuario);
        return Response.status(Response.Status.CREATED).entity(usuario).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarUsuario(@PathParam("id") Long id, Usuario usuarioAtualizado) {
        Usuario usuario = usuarioService.buscarPorId(id);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        usuarioAtualizado.id = id;
        usuarioService.atualizarUsuario(usuarioAtualizado);
        return Response.ok(usuarioAtualizado).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarUsuario(@PathParam("id") Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        usuarioService.deletarUsuario(id);
        return Response.noContent().build();
    }
} 