package org.estudos.jornadamilhas.resources;

import java.util.List;

import org.estudos.jornadamilhas.entity.Depoimento;
import org.estudos.jornadamilhas.repository.DepoimentoRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
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
    @Transactional
    public Response create (Depoimento depoimento){
        Depoimento.persist(depoimento);
        return Response.ok(depoimento).status(Response.Status.CREATED).build();
    }
}
