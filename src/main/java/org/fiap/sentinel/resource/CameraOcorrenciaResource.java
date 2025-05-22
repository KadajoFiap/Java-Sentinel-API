package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.CameraOcorrencia;
import org.fiap.sentinel.service.CameraOcorrenciaService;

import java.util.List;

@Path("/camera-ocorrencia")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CameraOcorrenciaResource {

    @Inject
    CameraOcorrenciaService cameraOcorrenciaService;

    @GET
    public List<CameraOcorrencia> listarCameraOcorrencias() {
        return cameraOcorrenciaService.listarCameraOcorrencias();
    }

    @GET
    @Path("/{cameraId}/{ocorrenciaId}")
    public Response buscarCameraOcorrencia(
            @PathParam("cameraId") Long cameraId,
            @PathParam("ocorrenciaId") Long ocorrenciaId) {
        CameraOcorrencia cameraOcorrencia = cameraOcorrenciaService.buscarPorId(cameraId, ocorrenciaId);
        if (cameraOcorrencia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(cameraOcorrencia).build();
    }

    @POST
    @Transactional
    public Response criarCameraOcorrencia(CameraOcorrencia cameraOcorrencia) {
        cameraOcorrenciaService.criarCameraOcorrencia(cameraOcorrencia);
        return Response.status(Response.Status.CREATED).entity(cameraOcorrencia).build();
    }

    @PUT
    @Path("/{cameraId}/{ocorrenciaId}")
    @Transactional
    public Response atualizarCameraOcorrencia(
            @PathParam("cameraId") Long cameraId,
            @PathParam("ocorrenciaId") Long ocorrenciaId,
            CameraOcorrencia cameraOcorrenciaAtualizada) {
        CameraOcorrencia cameraOcorrencia = cameraOcorrenciaService.buscarPorId(cameraId, ocorrenciaId);
        if (cameraOcorrencia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        cameraOcorrenciaService.atualizarCameraOcorrencia(cameraOcorrenciaAtualizada);
        return Response.ok(cameraOcorrenciaAtualizada).build();
    }

    @DELETE
    @Path("/{cameraId}/{ocorrenciaId}")
    @Transactional
    public Response deletarCameraOcorrencia(
            @PathParam("cameraId") Long cameraId,
            @PathParam("ocorrenciaId") Long ocorrenciaId) {
        CameraOcorrencia cameraOcorrencia = cameraOcorrenciaService.buscarPorId(cameraId, ocorrenciaId);
        if (cameraOcorrencia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        cameraOcorrenciaService.deletarCameraOcorrencia(cameraId, ocorrenciaId);
        return Response.noContent().build();
    }
} 