package org.estudos.jornadamilhas.depoimentos;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/depoimento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepoimentoResource {

    @Inject
    DepoimentosServiceImpl depoimentosService;

    @GET
    public List<Depoimento> listAll(){
        return this.depoimentosService.listAllDepoimentos();
    }

    @POST
    public Response create (Depoimento depoimento){
        Depoimento d = this.depoimentosService.create(depoimento);
        return Response.ok(d).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response atualizar(@PathParam("id") Long id, Depoimento d) {
        Depoimento depoimentoAtualizado = this.depoimentosService.atualizar(id, d);
        return Response.ok(depoimentoAtualizado).build();
    }

    @DELETE
    @Path("{id}")
    public Response apagar(@PathParam("id") Long id){
        this.depoimentosService.apagar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("total")
    public Long count(){
        return this.depoimentosService.getQtdDepoimentos();
    }

    @GET
    @Path("{id}")
    public Depoimento pesquisar(@PathParam("id") Long id) {
        return this.depoimentosService.procurar(id);
    }

    @GET
    @Path("depoimentos-home")
    public List<Depoimento> depoimentoHome(){
        return this.depoimentosService.depoimentoHome();
    }


}