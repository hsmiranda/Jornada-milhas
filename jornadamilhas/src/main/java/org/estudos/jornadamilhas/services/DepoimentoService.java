package org.estudos.jornadamilhas.services;

import java.util.List;

import org.estudos.jornadamilhas.domain.Depoimento;

public interface DepoimentoService {
    
    public List<Depoimento> listAllDepoimentos();
    public Depoimento create(Depoimento d);
    public Depoimento atualizar(Long id, Depoimento d);
    public void apagar(Long id);
    public Depoimento procurar(long id);
    public Long getQtdDepoimentos();
    public List<Depoimento> depoimentoHome();

}
