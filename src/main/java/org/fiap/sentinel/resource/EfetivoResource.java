package org.fiap.sentinel.resource;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.Efetivo;

import java.util.List;

@Path("/efetivo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EfetivoResource {

    @GET
    public List<Efetivo> listarEfetivos() {
        return Efetivo.listAll();
    }

    @GET
    @Path("/{id}")
    public Response buscarEfetivo(@PathParam("id") Long id) {
        Efetivo efetivo = Efetivo.findById(id);
        if (efetivo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(efetivo).build();
    }

    @POST
    @Transactional
    public Response criarEfetivo(Efetivo efetivo) {
        efetivo.persist();
        return Response.status(Response.Status.CREATED).entity(efetivo).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarEfetivo(@PathParam("id") Long id, Efetivo efetivoAtualizado) {
        Efetivo efetivo = Efetivo.findById(id);
        if (efetivo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        efetivo.ctps = efetivoAtualizado.ctps;
        efetivo.cpfEfetivo = efetivoAtualizado.cpfEfetivo;
        efetivo.dataRegistro = efetivoAtualizado.dataRegistro;

        return Response.ok(efetivo).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarEfetivo(@PathParam("id") Long id) {
        Efetivo efetivo = Efetivo.findById(id);
        if (efetivo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        efetivo.delete();
        return Response.noContent().build();
    }
} 