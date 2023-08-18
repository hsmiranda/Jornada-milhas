package org.estudos.jornadamilhas.services.impl;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.estudos.jornadamilhas.domain.Destino;
import org.estudos.jornadamilhas.repository.DestinosRepository;
import org.estudos.jornadamilhas.services.DestinoService;

import java.util.List;

@ApplicationScoped
public class DestinoServiceImpl implements DestinoService {

    @Inject
    DestinosRepository destinyRepository;


    @Override
    public List<Destino> listAllDestines() {
        return this.destinyRepository.listAllDestines();
    }

    @Override
    @Transactional
    public Destino create(Destino d) {
        return this.destinyRepository.create(d);
    }

    @Override
    @Transactional
    public Destino update(Long idDestino, Destino destino) {
        return this.destinyRepository.update(idDestino,destino);
    }

    @Override
    @Transactional
    public Boolean removeById(Long idDestino) {
        return this.destinyRepository.remove(idDestino);
    }

    @Override
    @Transactional
    public Destino findById(Long id){
        Destino d = this.destinyRepository.findById(id);

        if (d == null){
            Log.info("Destiny not found or null return");
                throw new WebApplicationException("Destiny not found,please send error for support service.", Response.Status.NOT_FOUND);
            
            }

        return d;
    }
    
}
