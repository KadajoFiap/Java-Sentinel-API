package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.Estacao;
import org.fiap.sentinel.service.EstacaoService;

import java.util.List;

@Path("/estacao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstacaoResource {

    @Inject
    EstacaoService estacaoService;

    @GET
    public List<Estacao> listarEstacoes() {
        return estacaoService.listarEstacoes();
    }

    @GET
    @Path("/{id}")
    public Response buscarEstacao(@PathParam("id") Long id) {
        Estacao estacao = estacaoService.buscarPorId(id);
        if (estacao == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(estacao).build();
    }

    @POST
    @Transactional
    public Response criarEstacao(Estacao estacao) {
        estacaoService.criarEstacao(estacao);
        return Response.status(Response.Status.CREATED).entity(estacao).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarEstacao(@PathParam("id") Long id, Estacao estacaoAtualizada) {
        Estacao estacao = estacaoService.buscarPorId(id);
        if (estacao == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        estacaoAtualizada.id = id;
        estacaoService.atualizarEstacao(estacaoAtualizada);
        return Response.ok(estacaoAtualizada).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarEstacao(@PathParam("id") Long id) {
        Estacao estacao = estacaoService.buscarPorId(id);
        if (estacao == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        estacaoService.deletarEstacao(id);
        return Response.noContent().build();
    }
} 