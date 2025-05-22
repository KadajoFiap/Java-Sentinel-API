package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.Linha;
import org.fiap.sentinel.service.LinhaService;

import java.util.List;

@Path("/linha")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LinhaResource {

    @Inject
    LinhaService linhaService;

    @GET
    public List<Linha> listarLinhas() {
        return linhaService.listarLinhas();
    }

    @GET
    @Path("/{nome}")
    public Response buscarLinha(@PathParam("nome") String nome) {
        Linha linha = linhaService.buscarPorNome(nome);
        if (linha == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(linha).build();
    }

    @POST
    @Transactional
    public Response criarLinha(Linha linha) {
        linhaService.criarLinha(linha);
        return Response.status(Response.Status.CREATED).entity(linha).build();
    }

    @PUT
    @Path("/{nome}")
    @Transactional
    public Response atualizarLinha(@PathParam("nome") String nome, Linha linhaAtualizada) {
        Linha linha = linhaService.buscarPorNome(nome);
        if (linha == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        linhaAtualizada.nome = nome;
        linhaService.atualizarLinha(linhaAtualizada);
        return Response.ok(linhaAtualizada).build();
    }

    @DELETE
    @Path("/{nome}")
    @Transactional
    public Response deletarLinha(@PathParam("nome") String nome) {
        Linha linha = linhaService.buscarPorNome(nome);
        if (linha == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        linhaService.deletarLinha(nome);
        return Response.noContent().build();
    }
} 