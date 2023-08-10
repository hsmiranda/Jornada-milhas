package org.estudos.jornadamilhas.resource;

import org.estudos.jornadamilhas.services.DestinoService;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/destino")
@Produces(MediaType.APPLICATION_JSON)
public class DestinosResource {
    
    private DestinoService DestinoService;

}
