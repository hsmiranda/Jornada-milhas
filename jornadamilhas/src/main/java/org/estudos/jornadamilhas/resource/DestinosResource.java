package org.estudos.jornadamilhas.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.estudos.jornadamilhas.domain.Destino;
import org.estudos.jornadamilhas.services.DestinoService;

import java.util.List;

@Path("/destino")
@Produces(MediaType.APPLICATION_JSON)
public class DestinosResource {
    
    @Inject
    DestinoService destinyService;

    @GET
    public List<Destino> listAll() {
        return this.destinyService.listAllDestines();
    }

    @POST
    public Response create(@Valid Destino destino) {
        this.destinyService.create(destino);
        return Response.ok(destino).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, @Valid Destino destino) {
        Destino updateDestiny = this.destinyService.update(id, destino);
        return Response.ok(updateDestiny).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        if (this.destinyService.removeById(id)) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        else {
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
    }

    @GET
    @Path("{id}")
    public Destino searchByDestinyId(@PathParam("id") Long id) {

        Destino d = null;

        try {
            d = this.destinyService.findById(id);
        } catch (WebApplicationException w) {
            Response.status(Response.Status.NOT_FOUND).entity(w.getMessage());
        }

        return d;
    }
}