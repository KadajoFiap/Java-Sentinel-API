package org.fiap.sentinel.resource;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiap.sentinel.model.Funcionario;

import java.util.List;

@Path("/funcionario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FuncionarioResource {

    @GET
    public List<Funcionario> listarFuncionarios() {
        return Funcionario.listAll();
    }

    @GET
    @Path("/{id}")
    public Response buscarFuncionario(@PathParam("id") Long id) {
        Funcionario funcionario = Funcionario.findById(id);
        if (funcionario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(funcionario).build();
    }

    @POST
    @Transactional
    public Response criarFuncionario(Funcionario funcionario) {
        funcionario.persist();
        return Response.status(Response.Status.CREATED).entity(funcionario).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarFuncionario(@PathParam("id") Long id, Funcionario funcionarioAtualizado) {
        Funcionario funcionario = Funcionario.findById(id);
        if (funcionario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        funcionario.nome = funcionarioAtualizado.nome;
        funcionario.cpf = funcionarioAtualizado.cpf;
        funcionario.status = funcionarioAtualizado.status;
        funcionario.sexoFuncionario = funcionarioAtualizado.sexoFuncionario;
        funcionario.cargo = funcionarioAtualizado.cargo;
        funcionario.departamento = funcionarioAtualizado.departamento;
        funcionario.dataContratacao = funcionarioAtualizado.dataContratacao;
        funcionario.email = funcionarioAtualizado.email;
        funcionario.telefone = funcionarioAtualizado.telefone;

        return Response.ok(funcionario).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarFuncionario(@PathParam("id") Long id) {
        Funcionario funcionario = Funcionario.findById(id);
        if (funcionario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        funcionario.delete();
        return Response.noContent().build();
    }
} 