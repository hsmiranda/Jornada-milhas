package org.estudos.jornadamilhas.destino;

import java.util.List;

public interface DestinoService {

    List<Destino> listAllDestines();
    Destino create(Destino destino);
    Destino update(Long idDestino, Destino destino);
    Boolean removeById(Long idDestino);
    Destino findById(Long id);
}
