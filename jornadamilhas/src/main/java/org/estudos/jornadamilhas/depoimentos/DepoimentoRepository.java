package org.estudos.jornadamilhas.depoimentos;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.util.List;


@ApplicationScoped
public class DepoimentoRepository implements PanacheRepository<Depoimento>{

    @Transactional
    public List<Depoimento> pesquisaTodos() {
        return listAll();
    }
    
    @Transactional
    public List<Depoimento> listByNome(String nome) {
        return find("nomePessoa = :nome", Parameters.with("nomePessoa", nome)).list();
    }

    @Transactional
    public Depoimento cadastrar(Depoimento d) {
        persist(d);
        return d;
    }

    @Transactional
    public Depoimento atualizar(Long id, Depoimento d) {

        Depoimento depoimentoEntity = findById(id);

        if(depoimentoEntity == null) {
            throw new WebApplicationException("Depoimento nao encontrado", Response.Status.NOT_FOUND);
        }

        depoimentoEntity.setTextoDepoimento(d.getTextoDepoimento());
        depoimentoEntity.setFoto(d.getFoto());
        depoimentoEntity.setNomePessoa(d.getNomePessoa());

        return depoimentoEntity;
    }

 
    @Transactional
    public void apagar(Long id) {
        Depoimento depoimentoEntity = findById(id);

        if(depoimentoEntity == null) {
            throw new WebApplicationException("Depoimento com o"+ id+ "nao encontrado", Response.Status.NOT_FOUND);
        }

        deleteById(depoimentoEntity.getId());
    }

    @Transactional
    public Depoimento pesquisarPorId(Long id) {

        Depoimento depoimentoEntity = findById(id);

        /**
         * Verifica se o depoimento existe.
         */
        if(depoimentoEntity == null){
            throw new WebApplicationException("Depoimento com o " + id + "nao encontrado", Response.Status.NOT_FOUND);
        }

        return depoimentoEntity;
    }

    @Transactional
    public Depoimento getPrimeiro(){
        return findAll().firstResult();
    }

}