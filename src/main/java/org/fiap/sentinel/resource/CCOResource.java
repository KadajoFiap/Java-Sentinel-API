package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.CCO;
import org.fiap.sentinel.service.CCOService;

import java.util.List;

@Path("/cco")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CCOResource {

    @Inject
    CCOService ccoService;

    @GET
    public List<CCO> listarCCOs() {
        return ccoService.listarCCOs();
    }

    @GET
    @Path("/{id}")
    public Response buscarCCO(@PathParam("id") Long id) {
        CCO cco = ccoService.buscarPorId(id);
        if (cco == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(cco).build();
    }

    @POST
    @Transactional
    public Response criarCCO(CCO cco) {
        ccoService.criarCCO(cco);
        return Response.status(Response.Status.CREATED).entity(cco).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarCCO(@PathParam("id") Long id, CCO ccoAtualizado) {
        CCO cco = ccoService.buscarPorId(id);
        if (cco == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ccoAtualizado.id = id;
        ccoService.atualizarCCO(ccoAtualizado);
        return Response.ok(ccoAtualizado).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarCCO(@PathParam("id") Long id) {
        CCO cco = ccoService.buscarPorId(id);
        if (cco == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ccoService.deletarCCO(id);
        return Response.noContent().build();
    }
} 