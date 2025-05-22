package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.VagaoCarro;
import org.fiap.sentinel.service.VagaoCarroService;

import java.util.List;

@Path("/vagao-carro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VagaoCarroResource {

    @Inject
    VagaoCarroService vagaoCarroService;

    @GET
    public List<VagaoCarro> listarVagaoCarros() {
        return vagaoCarroService.listarVagaoCarros();
    }

    @GET
    @Path("/{id}")
    public Response buscarVagaoCarro(@PathParam("id") Long id) {
        VagaoCarro vagaoCarro = vagaoCarroService.buscarPorId(id);
        if (vagaoCarro == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(vagaoCarro).build();
    }

    @POST
    @Transactional
    public Response criarVagaoCarro(VagaoCarro vagaoCarro) {
        vagaoCarroService.criarVagaoCarro(vagaoCarro);
        return Response.status(Response.Status.CREATED).entity(vagaoCarro).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarVagaoCarro(@PathParam("id") Long id, VagaoCarro vagaoCarroAtualizado) {
        VagaoCarro vagaoCarro = vagaoCarroService.buscarPorId(id);
        if (vagaoCarro == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        vagaoCarroAtualizado.id = id;
        vagaoCarroService.atualizarVagaoCarro(vagaoCarroAtualizado);
        return Response.ok(vagaoCarroAtualizado).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarVagaoCarro(@PathParam("id") Long id) {
        VagaoCarro vagaoCarro = vagaoCarroService.buscarPorId(id);
        if (vagaoCarro == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        vagaoCarroService.deletarVagaoCarro(id);
        return Response.noContent().build();
    }
} 