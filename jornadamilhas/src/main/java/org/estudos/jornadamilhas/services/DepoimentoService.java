package org.estudos.jornadamilhas.services;

import java.util.List;

import org.estudos.jornadamilhas.domain.Depoimento;

public interface DepoimentoService {
    
    public List<Depoimento> listAllDepoimentos();
    public Depoimento create(Depoimento d);
    public Depoimento atualizar(Depoimento d);
    public Depoimento apagar(Long id);
    public Depoimento procurar(long id);
    public Long getQtdDepoimentos();
    public List<Depoimento> depoimentoHome();

}
