package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.Infrator;
import org.fiap.sentinel.service.InfratorService;
import java.util.List;

@Path("/infrator")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InfratorResource {

    @Inject
    InfratorService infratorService;

    @POST
    public Response registrarInfrator(Infrator infrator) {
        try {
            infratorService.registrarInfrator(infrator);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao registrar infrator: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/{cpf}")
    public Response buscarInfratorPorCpf(@PathParam("cpf") String cpf) {
        try {
            Infrator infrator = infratorService.buscarInfratorPorCpf(cpf);
            if (infrator != null) {
                return Response.ok(infrator).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao buscar infrator: " + e.getMessage())
                    .build();
        }
    }

    @GET
    public Response listarTodosInfratores() {
        try {
            List<Infrator> infratores = infratorService.listarTodosInfratores();
            return Response.ok(infratores).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao listar infratores: " + e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{cpf}")
    public Response atualizarInfrator(@PathParam("cpf") String cpf, Infrator infrator) {
        try {
            Infrator infratorExistente = infratorService.buscarInfratorPorCpf(cpf);
            if (infratorExistente != null) {
                infratorService.atualizarInfrator(infrator);
                return Response.ok().build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao atualizar infrator: " + e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/{cpf}")
    public Response deletarInfrator(@PathParam("cpf") String cpf) {
        try {
            Infrator infrator = infratorService.buscarInfratorPorCpf(cpf);
            if (infrator != null) {
                infratorService.deletarInfrator(cpf);
                return Response.ok().build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao deletar infrator: " + e.getMessage())
                    .build();
        }
    }
} 