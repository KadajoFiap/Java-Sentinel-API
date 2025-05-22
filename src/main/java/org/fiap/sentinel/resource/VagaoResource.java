package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.Vagao;
import org.fiap.sentinel.service.VagaoService;
import java.util.List;

@Path("/vagao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VagaoResource {

    @Inject
    VagaoService vagaoService;

    @POST
    public Response registrarVagao(Vagao vagao) {
        try {
            vagaoService.registrarVagao(vagao);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao registrar vagão: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/{numero}")
    public Response buscarVagaoPorNumero(@PathParam("numero") Integer numero) {
        try {
            Vagao vagao = vagaoService.buscarVagaoPorNumero(numero);
            if (vagao != null) {
                return Response.ok(vagao).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao buscar vagão: " + e.getMessage())
                    .build();
        }
    }

    @GET
    public Response listarTodosVagoes() {
        try {
            List<Vagao> vagoes = vagaoService.listarTodosVagoes();
            return Response.ok(vagoes).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao listar vagões: " + e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{numero}")
    public Response atualizarVagao(@PathParam("numero") Integer numero, Vagao vagao) {
        try {
            Vagao vagaoExistente = vagaoService.buscarVagaoPorNumero(numero);
            if (vagaoExistente != null) {
                vagaoService.atualizarVagao(vagao);
                return Response.ok().build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao atualizar vagão: " + e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/{numero}")
    public Response deletarVagao(@PathParam("numero") Integer numero) {
        try {
            Vagao vagao = vagaoService.buscarVagaoPorNumero(numero);
            if (vagao != null) {
                vagaoService.deletarVagao(numero);
                return Response.ok().build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao deletar vagão: " + e.getMessage())
                    .build();
        }
    }
} 