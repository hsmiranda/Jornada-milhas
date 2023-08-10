package org.estudos.jornadamilhas.services.impl;

import java.util.List;

import org.estudos.jornadamilhas.domain.Destino;
import org.estudos.jornadamilhas.dto.DestinoDTO;
import org.estudos.jornadamilhas.repository.DestinosRepository;
import org.estudos.jornadamilhas.services.DestinoService;

import jakarta.inject.Inject;

public class DestinoServiceImpl implements DestinoService {

    @Inject
    private DestinosRepository destinosRepository;

    @Override
    public List<Destino> listAll() {
        return destinosRepository.listAll();
    }

    @Override
    public Destino cadastrar(DestinoDTO destinoDTO) {
        destinosRepository.cadastrar(destinoDTO.toDestino(destinoDTO));
        return destinosRepository.cadastrar(destinoDTO.toDestino(destinoDTO));
    }

    @Override
    public Destino atualizar() {
       return null;
    }

    @Override
    public Destino apagar() {
        return null;
    }
    
}
