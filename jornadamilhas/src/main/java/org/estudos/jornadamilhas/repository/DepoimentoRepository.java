package org.estudos.jornadamilhas.repository;

import java.util.List;

import org.estudos.jornadamilhas.entity.Depoimento;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DepoimentoRepository implements PanacheRepository<Depoimento>{

    /**
     * Metodo responsavel por listar todos os depoimentos.
     * 
     * @return lista com todos os depoimentos.
     */
    public List<Depoimento> listAll() {
        return Depoimento.listAll();
    }
    



}
