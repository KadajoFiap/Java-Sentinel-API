package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.EstacaoLinha;
import org.fiap.sentinel.service.EstacaoLinhaService;

import java.util.List;

@Path("/estacao-linha")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstacaoLinhaResource {

    @Inject
    EstacaoLinhaService estacaoLinhaService;

    @GET
    public List<EstacaoLinha> listarEstacaoLinhas() {
        return estacaoLinhaService.listarEstacaoLinhas();
    }

    @GET
    @Path("/{estacaoId}/{linhaId}")
    public Response buscarEstacaoLinha(
            @PathParam("estacaoId") Long estacaoId,
            @PathParam("linhaId") Long linhaId) {
        EstacaoLinha estacaoLinha = estacaoLinhaService.buscarPorId(estacaoId, linhaId);
        if (estacaoLinha == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(estacaoLinha).build();
    }

    @POST
    @Transactional
    public Response criarEstacaoLinha(EstacaoLinha estacaoLinha) {
        estacaoLinhaService.criarEstacaoLinha(estacaoLinha);
        return Response.status(Response.Status.CREATED).entity(estacaoLinha).build();
    }

    @PUT
    @Path("/{estacaoId}/{linhaId}")
    @Transactional
    public Response atualizarEstacaoLinha(
            @PathParam("estacaoId") Long estacaoId,
            @PathParam("linhaId") Long linhaId,
            EstacaoLinha estacaoLinhaAtualizada) {
        EstacaoLinha estacaoLinha = estacaoLinhaService.buscarPorId(estacaoId, linhaId);
        if (estacaoLinha == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        estacaoLinhaService.atualizarEstacaoLinha(estacaoLinhaAtualizada);
        return Response.ok(estacaoLinhaAtualizada).build();
    }

    @DELETE
    @Path("/{estacaoId}/{linhaId}")
    @Transactional
    public Response deletarEstacaoLinha(
            @PathParam("estacaoId") Long estacaoId,
            @PathParam("linhaId") Long linhaId) {
        EstacaoLinha estacaoLinha = estacaoLinhaService.buscarPorId(estacaoId, linhaId);
        if (estacaoLinha == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        estacaoLinhaService.deletarEstacaoLinha(estacaoId, linhaId);
        return Response.noContent().build();
    }
} 