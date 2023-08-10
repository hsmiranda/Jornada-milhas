package org.estudos.jornadamilhas.services;

import java.util.List;

import org.estudos.jornadamilhas.domain.Destino;

public interface DestinoService {

    public List<Destino> listarTodos(); 
    public Destino cadastrar(Destino destino);
    public Destino atualizar(Long idDestino, Destino destino);
    public Boolean apagar(Long idDestino);
}
