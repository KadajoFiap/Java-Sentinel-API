package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.Camera;
import org.fiap.sentinel.service.CameraService;

import java.util.List;

@Path("/camera")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CameraResource {

    @Inject
    CameraService cameraService;

    @GET
    public List<Camera> listarCameras() {
        return cameraService.listarCameras();
    }

    @GET
    @Path("/{id}")
    public Response buscarCamera(@PathParam("id") Long id) {
        Camera camera = cameraService.buscarPorId(id);
        if (camera == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(camera).build();
    }

    @POST
    @Transactional
    public Response criarCamera(Camera camera) {
        cameraService.criarCamera(camera);
        return Response.status(Response.Status.CREATED).entity(camera).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarCamera(@PathParam("id") Long id, Camera cameraAtualizada) {
        Camera camera = cameraService.buscarPorId(id);
        if (camera == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        cameraAtualizada.id = id;
        cameraService.atualizarCamera(cameraAtualizada);
        return Response.ok(cameraAtualizada).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarCamera(@PathParam("id") Long id) {
        Camera camera = cameraService.buscarPorId(id);
        if (camera == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        cameraService.deletarCamera(id);
        return Response.noContent().build();
    }
} 