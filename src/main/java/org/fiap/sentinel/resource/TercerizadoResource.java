package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.Tercerizado;
import org.fiap.sentinel.service.TercerizadoService;

import java.util.List;

@Path("/tercerizado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TercerizadoResource {

    @Inject
    TercerizadoService tercerizadoService;

    @GET
    public List<Tercerizado> listarTercerizados() {
        return tercerizadoService.listarTercerizados();
    }

    @GET
    @Path("/{id}")
    public Response buscarTercerizado(@PathParam("id") Long id) {
        Tercerizado tercerizado = tercerizadoService.buscarPorId(id);
        if (tercerizado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(tercerizado).build();
    }

    @POST
    @Transactional
    public Response criarTercerizado(Tercerizado tercerizado) {
        tercerizadoService.criarTercerizado(tercerizado);
        return Response.status(Response.Status.CREATED).entity(tercerizado).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarTercerizado(@PathParam("id") Long id, Tercerizado tercerizadoAtualizado) {
        Tercerizado tercerizado = tercerizadoService.buscarPorId(id);
        if (tercerizado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        tercerizadoAtualizado.id = id;
        tercerizadoService.atualizarTercerizado(tercerizadoAtualizado);
        return Response.ok(tercerizadoAtualizado).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarTercerizado(@PathParam("id") Long id) {
        Tercerizado tercerizado = tercerizadoService.buscarPorId(id);
        if (tercerizado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        tercerizadoService.deletarTercerizado(id);
        return Response.noContent().build();
    }
} 