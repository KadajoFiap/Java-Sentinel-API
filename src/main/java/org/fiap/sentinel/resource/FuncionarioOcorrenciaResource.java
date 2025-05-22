package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.FuncionarioOcorrencia;
import org.fiap.sentinel.service.FuncionarioOcorrenciaService;

import java.util.List;

@Path("/funcionario-ocorrencia")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FuncionarioOcorrenciaResource {

    @Inject
    FuncionarioOcorrenciaService funcionarioOcorrenciaService;

    @GET
    public List<FuncionarioOcorrencia> listarFuncionarioOcorrencias() {
        return funcionarioOcorrenciaService.listarFuncionarioOcorrencias();
    }

    @GET
    @Path("/{funcionarioId}/{ocorrenciaId}")
    public Response buscarFuncionarioOcorrencia(
            @PathParam("funcionarioId") Long funcionarioId,
            @PathParam("ocorrenciaId") Long ocorrenciaId) {
        FuncionarioOcorrencia funcionarioOcorrencia = funcionarioOcorrenciaService.buscarPorId(funcionarioId, ocorrenciaId);
        if (funcionarioOcorrencia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(funcionarioOcorrencia).build();
    }

    @POST
    @Transactional
    public Response criarFuncionarioOcorrencia(FuncionarioOcorrencia funcionarioOcorrencia) {
        funcionarioOcorrenciaService.criarFuncionarioOcorrencia(funcionarioOcorrencia);
        return Response.status(Response.Status.CREATED).entity(funcionarioOcorrencia).build();
    }

    @PUT
    @Path("/{funcionarioId}/{ocorrenciaId}")
    @Transactional
    public Response atualizarFuncionarioOcorrencia(
            @PathParam("funcionarioId") Long funcionarioId,
            @PathParam("ocorrenciaId") Long ocorrenciaId,
            FuncionarioOcorrencia funcionarioOcorrenciaAtualizada) {
        FuncionarioOcorrencia funcionarioOcorrencia = funcionarioOcorrenciaService.buscarPorId(funcionarioId, ocorrenciaId);
        if (funcionarioOcorrencia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        funcionarioOcorrenciaService.atualizarFuncionarioOcorrencia(funcionarioOcorrenciaAtualizada);
        return Response.ok(funcionarioOcorrenciaAtualizada).build();
    }

    @DELETE
    @Path("/{funcionarioId}/{ocorrenciaId}")
    @Transactional
    public Response deletarFuncionarioOcorrencia(
            @PathParam("funcionarioId") Long funcionarioId,
            @PathParam("ocorrenciaId") Long ocorrenciaId) {
        FuncionarioOcorrencia funcionarioOcorrencia = funcionarioOcorrenciaService.buscarPorId(funcionarioId, ocorrenciaId);
        if (funcionarioOcorrencia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        funcionarioOcorrenciaService.deletarFuncionarioOcorrencia(funcionarioId, ocorrenciaId);
        return Response.noContent().build();
    }
} 