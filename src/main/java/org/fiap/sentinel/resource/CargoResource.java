package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.Cargo;
import org.fiap.sentinel.service.CargoService;

import java.util.List;

@Path("/cargo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CargoResource {

    @Inject
    CargoService cargoService;

    @GET
    public List<Cargo> listarCargos() {
        return cargoService.listarCargos();
    }

    @GET
    @Path("/{id}")
    public Response buscarCargo(@PathParam("id") Long id) {
        Cargo cargo = cargoService.buscarPorId(id);
        if (cargo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(cargo).build();
    }

    @POST
    @Transactional
    public Response criarCargo(Cargo cargo) {
        cargoService.criarCargo(cargo);
        return Response.status(Response.Status.CREATED).entity(cargo).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarCargo(@PathParam("id") Long id, Cargo cargoAtualizado) {
        Cargo cargo = cargoService.buscarPorId(id);
        if (cargo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        cargoAtualizado.id = id;
        cargoService.atualizarCargo(cargoAtualizado);
        return Response.ok(cargoAtualizado).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarCargo(@PathParam("id") Long id) {
        Cargo cargo = cargoService.buscarPorId(id);
        if (cargo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        cargoService.deletarCargo(id);
        return Response.noContent().build();
    }
} 