package org.estudos.jornadamilhas.resources;

import java.util.List;

import org.estudos.jornadamilhas.entity.Depoimento;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/depoimentos")
@Produces(MediaType.APPLICATION_JSON)
public class DepoimentoResource {

    @GET
    public List<Depoimento> listAll(){
        return Depoimento.listAll();
    }

    @POST
    @Transactional
    public Response create (Depoimento depoimento){
        Depoimento.persist(depoimento);
        return Response.ok(depoimento).status(Response.Status.CREATED).build();
    }
}
