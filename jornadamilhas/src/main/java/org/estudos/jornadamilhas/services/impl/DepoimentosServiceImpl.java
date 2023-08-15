package org.estudos.jornadamilhas.services.impl;

import java.util.List;

import org.estudos.jornadamilhas.domain.Depoimento;
import org.estudos.jornadamilhas.repository.DepoimentoRepository;
import org.estudos.jornadamilhas.services.DepoimentoService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DepoimentosServiceImpl implements DepoimentoService{

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'procurar'");
    }

    @Override
    public Long getQtdDepoimentos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQtdDepoimentos'");
    }

    @Override
    public List<Depoimento> depoimentoHome() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depoimentoHome'");
    }
    
}
