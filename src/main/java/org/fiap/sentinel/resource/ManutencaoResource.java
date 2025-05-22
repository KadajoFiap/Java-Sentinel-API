package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.Manutencao;
import org.fiap.sentinel.service.ManutencaoService;
import java.util.List;

@Path("/manutencao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ManutencaoResource {

    @Inject
    ManutencaoService manutencaoService;

    @POST
    public Response registrarManutencao(Manutencao manutencao) {
        try {
            manutencaoService.registrarManutencao(manutencao);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao registrar manutenção: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    public Response buscarManutencaoPorId(@PathParam("id") Long id) {
        try {
            Manutencao manutencao = manutencaoService.buscarManutencaoPorId(id);
            if (manutencao != null) {
                return Response.ok(manutencao).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao buscar manutenção: " + e.getMessage())
                    .build();
        }
    }

    @GET
    public Response listarTodasManutencoes() {
        try {
            List<Manutencao> manutencoes = manutencaoService.listarTodasManutencoes();
            return Response.ok(manutencoes).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao listar manutenções: " + e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizarManutencao(@PathParam("id") Long id, Manutencao manutencao) {
        try {
            Manutencao manutencaoExistente = manutencaoService.buscarManutencaoPorId(id);
            if (manutencaoExistente != null) {
                manutencaoService.atualizarManutencao(manutencao);
                return Response.ok().build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao atualizar manutenção: " + e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletarManutencao(@PathParam("id") Long id) {
        try {
            Manutencao manutencao = manutencaoService.buscarManutencaoPorId(id);
            if (manutencao != null) {
                manutencaoService.deletarManutencao(id);
                return Response.ok().build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao deletar manutenção: " + e.getMessage())
                    .build();
        }
    }
} 