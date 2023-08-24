package org.estudos.jornadamilhas.destino;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class DestinosRepository implements PanacheRepository<Destino>{
    
    @Transactional
    public List<Destino> listAllDestines() {
        return listAll();
    }

    @Transactional
    public Destino create(Destino d) {
        persist(d);
        return d;
    }

    @Transactional
    public Destino update(Long id, Destino d){
        
        Destino de = findById(id);
        
        if (de == null) {
            throw new WebApplicationException("Destiny not found,please send error for support service.");
        }

        de.setFoto1Destino(d.getFoto1Destino());
        de.setFoto1Destino(d.getFoto2Destino());
        de.setMetaDestino(d.getMetaDestino());
        de.setNomeDestino(d.getNomeDestino());
        de.setPrecoDestino(d.getPrecoDestino());

        persist(de);

        return de;
    }

    @Transactional
    public Boolean remove(Long idLong){
        Destino destinyTemp = findById(idLong);

        if(destinyTemp == null) {
            throw new WebApplicationException("Destiny with: "+idLong+" not found.", Response.Status.NOT_FOUND);
        }
        
        return deleteById(destinyTemp.getIdDestino());
    }
}