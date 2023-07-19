package org.estudos.jornadamilhas.repository;

import java.util.List;

import org.estudos.jornadamilhas.entity.Depoimento;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

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
    
    /**
     * @param nome
     * @return
     */
    public List<Depoimento> listByNome(String nome) {
        return Depoimento.find("nomePessoa = :nome", Parameters.with("nomePessoa", nome)).list();
    }

    /**
     * @param d
     * @return
     */
    @Transactional
    public Depoimento cadastrar(Depoimento d) {
        Depoimento.persist(d);
        return d;
    }

    /**
     * @param id
     * @param d
     * @return
     */
    @Transactional
    public Depoimento atualizar(Long id, Depoimento d) {

        Depoimento depoimentoEntity = Depoimento.findById(id);

        if(depoimentoEntity == null) {
            throw new WebApplicationException("Depoimento nao encontrado", Response.Status.NOT_FOUND);
        }

        depoimentoEntity.setDepoimento(d.getDepoimento());
        depoimentoEntity.setFoto(d.getFoto());
        depoimentoEntity.setNomePessoa(d.getNomePessoa());

        return depoimentoEntity;
    }

    /**
     * @param id
     */
    @Transactional
    public void apagar(Long id) {
        Depoimento depoimentoEntity = Depoimento.findById(id);

        if(depoimentoEntity == null) {
            throw new WebApplicationException("Depoimento com o"+ id+ "nao encontrado", Response.Status.NOT_FOUND);
        }

        Depoimento.deleteById(depoimentoEntity.getId());
    }


}
