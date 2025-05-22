package org.fiap.sentinel.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.Relatorio;
import org.fiap.sentinel.service.RelatorioService;

import java.util.List;

@Path("/relatorios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RelatorioResource {

    @Inject
    RelatorioService service;

    @GET
    public List<Relatorio> listar(){
        return service.listarTodosRelatorios();
    }

    @GET
    @Path("/{id}")
    public Relatorio buscar(@PathParam("id") Long id){
        Relatorio relatorio = service.buscarPorId(id);
        if (relatorio == null){
            throw new NotFoundException("Carro com ID " + id + " não encontrado.");
        }
        return relatorio;
    }

    @POST
    public Response salvar(Relatorio relatorio){
        service.salvar(relatorio);
        return Response.status(Response.Status.CREATED).entity(relatorio).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Relatorio atualizado){
        service.atualizarRelatorio(id, atualizado);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        service.deletarRelatorio(id);
        return Response.noContent().build();
    }
}
