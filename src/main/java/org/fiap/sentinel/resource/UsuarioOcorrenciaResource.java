package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.UsuarioOcorrencia;
import org.fiap.sentinel.service.UsuarioOcorrenciaService;

import java.util.List;

@Path("/usuario-ocorrencia")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioOcorrenciaResource {

    @Inject
    UsuarioOcorrenciaService usuarioOcorrenciaService;

    @GET
    public List<UsuarioOcorrencia> listarUsuarioOcorrencias() {
        return usuarioOcorrenciaService.listarUsuarioOcorrencias();
    }

    @GET
    @Path("/{usuarioId}/{ocorrenciaId}")
    public Response buscarUsuarioOcorrencia(
            @PathParam("usuarioId") Long usuarioId,
            @PathParam("ocorrenciaId") Long ocorrenciaId) {
        UsuarioOcorrencia usuarioOcorrencia = usuarioOcorrenciaService.buscarPorId(usuarioId, ocorrenciaId);
        if (usuarioOcorrencia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(usuarioOcorrencia).build();
    }

    @POST
    @Transactional
    public Response criarUsuarioOcorrencia(UsuarioOcorrencia usuarioOcorrencia) {
        usuarioOcorrenciaService.criarUsuarioOcorrencia(usuarioOcorrencia);
        return Response.status(Response.Status.CREATED).entity(usuarioOcorrencia).build();
    }

    @PUT
    @Path("/{usuarioId}/{ocorrenciaId}")
    @Transactional
    public Response atualizarUsuarioOcorrencia(
            @PathParam("usuarioId") Long usuarioId,
            @PathParam("ocorrenciaId") Long ocorrenciaId,
            UsuarioOcorrencia usuarioOcorrenciaAtualizada) {
        UsuarioOcorrencia usuarioOcorrencia = usuarioOcorrenciaService.buscarPorId(usuarioId, ocorrenciaId);
        if (usuarioOcorrencia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        usuarioOcorrenciaService.atualizarUsuarioOcorrencia(usuarioOcorrenciaAtualizada);
        return Response.ok(usuarioOcorrenciaAtualizada).build();
    }

    @DELETE
    @Path("/{usuarioId}/{ocorrenciaId}")
    @Transactional
    public Response deletarUsuarioOcorrencia(
            @PathParam("usuarioId") Long usuarioId,
            @PathParam("ocorrenciaId") Long ocorrenciaId) {
        UsuarioOcorrencia usuarioOcorrencia = usuarioOcorrenciaService.buscarPorId(usuarioId, ocorrenciaId);
        if (usuarioOcorrencia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        usuarioOcorrenciaService.deletarUsuarioOcorrencia(usuarioId, ocorrenciaId);
        return Response.noContent().build();
    }
} 