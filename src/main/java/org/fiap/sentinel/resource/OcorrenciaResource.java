package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.Ocorrencia;
import org.fiap.sentinel.service.OcorrenciaService;
import java.time.LocalDateTime;
import java.util.List;

@Path("/ocorrencia")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OcorrenciaResource {
    
    @Inject
    OcorrenciaService ocorrenciaService;

    @GET
    public List<Ocorrencia> listarOcorrencias() {
        return Ocorrencia.listAll();
    }

    @GET
    @Path("/{id}")
    public Response buscarOcorrencia(@PathParam("id") Long id) {
        Ocorrencia ocorrencia = Ocorrencia.findById(id);
        if (ocorrencia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(ocorrencia).build();
    }

    @POST
    @Transactional
    public Response criarOcorrencia(Ocorrencia ocorrencia) {
        if (ocorrencia == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Ocorrência não pode ser nula")
                    .build();
        }

        if (ocorrencia.dataInicio == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Data de início é obrigatória")
                    .build();
        }

        if (ocorrencia.severidadeOcorrencia == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Severidade é obrigatória")
                    .build();
        }

        if (ocorrencia.statusOcorrencia == null) {
            ocorrencia.statusOcorrencia = "ABERTO";
        }

        ocorrencia.persist();
        return Response.status(Response.Status.CREATED).entity(ocorrencia).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarOcorrencia(@PathParam("id") Long id, Ocorrencia ocorrenciaAtualizada) {
        Ocorrencia ocorrencia = Ocorrencia.findById(id);
        if (ocorrencia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        if (ocorrenciaAtualizada.dataInicio == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Data de início é obrigatória")
                    .build();
        }

        if (ocorrenciaAtualizada.severidadeOcorrencia == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Severidade é obrigatória")
                    .build();
        }

        ocorrencia.dataInicio = ocorrenciaAtualizada.dataInicio;
        ocorrencia.dataFim = ocorrenciaAtualizada.dataFim;
        ocorrencia.tipoOcorrencia = ocorrenciaAtualizada.tipoOcorrencia;
        ocorrencia.descricaoOcorrencia = ocorrenciaAtualizada.descricaoOcorrencia;
        ocorrencia.severidadeOcorrencia = ocorrenciaAtualizada.severidadeOcorrencia;
        ocorrencia.statusOcorrencia = ocorrenciaAtualizada.statusOcorrencia != null ? 
            ocorrenciaAtualizada.statusOcorrencia : "ABERTO";

        return Response.ok(ocorrencia).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarOcorrencia(@PathParam("id") Long id) {
        Ocorrencia ocorrencia = Ocorrencia.findById(id);
        if (ocorrencia == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ocorrencia.delete();
        return Response.noContent().build();
    }
    
    @GET
    @Path("/trem/{numeroTrem}")
    public Response buscarOcorrenciasPorTremEPeriodo(
            @PathParam("numeroTrem") String numeroTrem,
            @QueryParam("dataInicio") String dataInicio,
            @QueryParam("dataFim") String dataFim) {
        try {
            LocalDateTime inicio = LocalDateTime.parse(dataInicio);
            LocalDateTime fim = LocalDateTime.parse(dataFim);
            List<Ocorrencia> ocorrencias = ocorrenciaService.buscarOcorrenciasPorTremEPeriodo(numeroTrem, inicio, fim);
            return Response.ok(ocorrencias).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao buscar ocorrências: " + e.getMessage())
                    .build();
        }
    }
    
    @GET
    @Path("/criticas")
    public Response buscarOcorrenciasCriticas() {
        try {
            List<Ocorrencia> ocorrencias = ocorrenciaService.buscarOcorrenciasCriticas();
            return Response.ok(ocorrencias).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao buscar ocorrências críticas: " + e.getMessage())
                    .build();
        }
    }
} 