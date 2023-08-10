package org.estudos.jornadamilhas.repository;

import java.util.List;

import org.estudos.jornadamilhas.domain.Destino;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class DestinosRepository implements PanacheRepository<Destino>{
    
    @Transactional
    public List<Destino> listarTodos(){
        return listAll();
    }

    @Transactional
    public Destino cadastrar(Destino d) {
        persist(d);
        return d;
    }

    @Transactional
    public Destino atualizar(Long id, Destino d){
        
        Destino de = findById(id);
        
        if (de == null) {
            throw new WebApplicationException("Destino não encontrado");
        }

        de.setFotoDestino(d.getFotoDestino());
        de.setNomeDestino(d.getNomeDestino());
        de.setPrecoDestino(d.getPrecoDestino());

        return de;
    }

    @Transactional
    public void apagar(Long idLong){
        Destino destinoTemp = findById(idLong);

        if(destinoTemp == null) {
            throw new WebApplicationException("Destino nao encontrado com o id: "+idLong, Response.Status.NOT_FOUND);
        }
        
        delete(destinoTemp);
    }

    @Transactional
    public Destino pesquisarDesinoPorNome(String nomeParm){
        return find("nomeDestino", nomeParm).firstResult();
    }

}