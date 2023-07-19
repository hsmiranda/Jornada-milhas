package org.estudos.jornadamilhas.resources;

import java.util.List;

import org.estudos.jornadamilhas.entity.Depoimento;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/depoimentos")
@Produces(MediaType.APPLICATION_JSON)
public class DepoimentoResource {

    @GET
    public List<Depoimento> listAll(){
        return Depoimento.listAll();
    }
}
