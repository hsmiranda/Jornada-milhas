package org.estudos.jornadamilhas.resource;

import java.util.List;

import org.estudos.jornadamilhas.domain.Destino;
import org.estudos.jornadamilhas.services.impl.DestinoServiceImpl;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/destino")
@Produces(MediaType.APPLICATION_JSON)
public class DestinosResource {
    
    @Inject
    DestinoServiceImpl destinoService;

    @GET
    public List<Destino> listAll(){
        return destinoService.listarTodos();
    }

    @POST
    public Response create (Destino destino){
        destinoService.cadastrar(destino);
        return Response.ok(destino).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response atualizar(@PathParam("id") Long id, Destino destino) {
        Destino destinoAtualizado = destinoService.atualizar(id, destino);
        return  Response.ok(destinoAtualizado).build();
    }

    @DELETE
    @Path("{id}")
    public Response apagar(@PathParam("id") Long id){
        destinoService.apagar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}