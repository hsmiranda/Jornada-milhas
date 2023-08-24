package org.estudos.jornadamilhas.depoimentos;

import java.util.List;

public interface DepoimentoService {

    List<Depoimento> listAllDepoimentos();

    Depoimento create(Depoimento d);

    Depoimento atualizar(Long id, Depoimento d);

    void apagar(Long id);

    Depoimento procurar(long id);

    Long getQtdDepoimentos();

    List<Depoimento> depoimentoHome();

}
