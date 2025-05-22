package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.Evidencia;
import org.fiap.sentinel.service.EvidenciaService;

import java.util.List;

@Path("/evidencia")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EvidenciaResource {

    @Inject
    EvidenciaService evidenciaService;

    @GET
    public List<Evidencia> listarEvidencias() {
        return evidenciaService.listarEvidencias();
    }

    @GET
    @Path("/{id}")
    public Response buscarEvidencia(@PathParam("id") Long id) {
        Evidencia evidencia = evidenciaService.buscarPorId(id);
        if (evidencia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(evidencia).build();
    }

    @POST
    @Transactional
    public Response criarEvidencia(Evidencia evidencia) {
        evidenciaService.criarEvidencia(evidencia);
        return Response.status(Response.Status.CREATED).entity(evidencia).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarEvidencia(@PathParam("id") Long id, Evidencia evidenciaAtualizada) {
        Evidencia evidencia = evidenciaService.buscarPorId(id);
        if (evidencia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        evidenciaAtualizada.id = id;
        evidenciaService.atualizarEvidencia(evidenciaAtualizada);
        return Response.ok(evidenciaAtualizada).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarEvidencia(@PathParam("id") Long id) {
        Evidencia evidencia = evidenciaService.buscarPorId(id);
        if (evidencia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        evidenciaService.deletarEvidencia(id);
        return Response.noContent().build();
    }
} 