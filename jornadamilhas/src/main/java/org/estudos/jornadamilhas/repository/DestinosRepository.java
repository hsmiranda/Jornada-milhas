package org.estudos.jornadamilhas.repository;

import java.util.List;

import org.estudos.jornadamilhas.entity.Destinos;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DestinosRepository implements PanacheRepository<Destinos>{
    
    @Transactional
    public List<Destinos> listarTodos(){
        return listAll();
    }

}
