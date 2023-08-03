package org.estudos.jornadamilhas.repository;

import java.util.List;

import org.estudos.jornadamilhas.entity.Depoimento;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

/**
 * Classe responsavel por implementa o acesso ao banco de dados.
 * 
 */
@ApplicationScoped
public class DepoimentoRepository implements PanacheRepository<Depoimento>{

    /**
     * Metodo responsavel por listar todos os depoimentos.
     * 
     * @return lista com todos os depoimentos.
     */
    public List<Depoimento> pesquisaTodos() {
        return listAll();
    }
    
    /**
     * Metodo responsavel por pesquisar todos por nome.
     * 
     * @param nome
     * @return
     */
    public List<Depoimento> listByNome(String nome) {
        return find("nomePessoa = :nome", Parameters.with("nomePessoa", nome)).list();
    }

    /**
     * Metodo que realiza o cadastro do depoimento.
     * 
     * @param d
     * @return
     */
    @Transactional
    public Depoimento cadastrar(Depoimento d) {
        persist(d);
        return d;
    }

    /**
     * Metodo que realiza a atualizacao do Depoimento.
     * 
     * @param id
     * @param d
     * @return
     */
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

    /**
     * Apaga um depoimento fiscamente do banco.
     * 
     * @param id
     */
    @Transactional
    public void apagar(Long id) {
        Depoimento depoimentoEntity = findById(id);

        if(depoimentoEntity == null) {
            throw new WebApplicationException("Depoimento com o"+ id+ "nao encontrado", Response.Status.NOT_FOUND);
        }

        deleteById(depoimentoEntity.getId());
    }

    /**
     * Pesquisa o depoimento por um ID
     * 
     * @param idLong
     * 
     * @return depoimento com o ID especifico.
     */
    public Depoimento pesquisarPorId(Long idLong){

        Depoimento depoimentoEntity = findById(idLong);

        /**
         * Verifica se o depoimento existe.
         */
        if(depoimentoEntity == null){
            throw new NotFoundException();
        }

        return depoimentoEntity;
    }

}
