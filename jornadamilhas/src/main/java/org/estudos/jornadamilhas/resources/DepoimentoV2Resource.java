package org.estudos.jornadamilhas.resources;

import java.util.List;

import org.estudos.jornadamilhas.entity.Depoimento;
import org.estudos.jornadamilhas.repository.DepoimentoRepository;

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

@Path("/depoimentos/v2")
@Produces(MediaType.APPLICATION_JSON)
public class DepoimentoV2Resource {

    @Inject
    private DepoimentoRepository depoimentoRepository;


    @GET
    public List<Depoimento> listAll(){
        return depoimentoRepository.listAll();
    }

    @POST
    public Response create (Depoimento depoimento){
        depoimentoRepository.cadastrar(depoimento);
        return Response.ok(depoimento).status(Response.Status.CREATED).build();
    }


    @PUT
    @Path("{id}")
    public Response atualizar(@PathParam("id") Long id, Depoimento d) {
        Depoimento depoimentoAtualizado = depoimentoRepository.atualizar(id, d);
        return Response.ok(depoimentoAtualizado).build();
    }

    @DELETE
    @Path("{id}")
    public Response apagar(@PathParam("id") Long id){
        depoimentoRepository.apagar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
