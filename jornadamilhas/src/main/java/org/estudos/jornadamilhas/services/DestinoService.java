package org.estudos.jornadamilhas.services;

import java.util.List;

import org.estudos.jornadamilhas.domain.Destino;
import org.estudos.jornadamilhas.dto.DestinoDTO;

public interface DestinoService {

    public List<Destino> listAll(); 
    public Destino cadastrar(DestinoDTO destinoDTO);
    public Destino atualizar();
    public Destino apagar();
}
