package org.estudos.jornadamilhas.depoimentos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class DepoimentosServiceImpl implements DepoimentoService {

    @Inject
    DepoimentoRepository depoimentoRepository;

    @Override
    public List<Depoimento> listAllDepoimentos() {
        return this.depoimentoRepository.listAll();
    }

    @Override
    public Depoimento create(Depoimento d) {
        return this.depoimentoRepository.cadastrar(d);
    }

    @Override
    public Depoimento atualizar(Long id, Depoimento d) {
        return this.depoimentoRepository.atualizar(id, d);
    }

    @Override
    public void apagar(Long id) {
       this.depoimentoRepository.apagar(id);
    }   

    @Override
    public Depoimento procurar(long id) {
        return this.depoimentoRepository.pesquisarPorId(id);
    }

    @Override
    public Long getQtdDepoimentos() {
       return (long) this.depoimentoRepository.listAll().size();
    }

    @Override
    public List<Depoimento> depoimentoHome() {
       DepoimentoBO depoimentoBO = new DepoimentoBO();
       return depoimentoBO.getDepoimentosHome();
    }
    
}
