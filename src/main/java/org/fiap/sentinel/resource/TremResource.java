package org.fiap.sentinel.resource;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.Trem;

import java.util.List;

@Path("/trem")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TremResource {

    @GET
    public List<Trem> listarTrens() {
        return Trem.listAll();
    }

    @GET
    @Path("/{id}")
    public Response buscarTrem(@PathParam("id") Long id) {
        Trem trem = Trem.findById(id);
        if (trem == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(trem).build();
    }

    @POST
    @Transactional
    public Response criarTrem(Trem trem) {
        trem.persist();
        return Response.status(Response.Status.CREATED).entity(trem).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarTrem(@PathParam("id") Long id, Trem tremAtualizado) {
        Trem trem = Trem.findById(id);
        if (trem == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        trem.fabricante = tremAtualizado.fabricante;
        trem.dataFabrTrem = tremAtualizado.dataFabrTrem;
        trem.modeloTrem = tremAtualizado.modeloTrem;
        trem.numero = tremAtualizado.numero;
        trem.status = tremAtualizado.status;
        trem.origem = tremAtualizado.origem;
        trem.destino = tremAtualizado.destino;
        trem.observacoes = tremAtualizado.observacoes;

        return Response.ok(trem).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarTrem(@PathParam("id") Long id) {
        Trem trem = Trem.findById(id);
        if (trem == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        trem.delete();
        return Response.noContent().build();
    }
} 