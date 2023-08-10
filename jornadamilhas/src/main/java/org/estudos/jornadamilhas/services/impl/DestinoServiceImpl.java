package org.estudos.jornadamilhas.services.impl;

import java.util.List;

import org.estudos.jornadamilhas.domain.Destino;
import org.estudos.jornadamilhas.repository.DestinosRepository;
import org.estudos.jornadamilhas.services.DestinoService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DestinoServiceImpl implements DestinoService {

    @Inject
    private DestinosRepository destinosRepository;

    @Override
    public List<Destino> listarTodos() {
        return destinosRepository.listAll();
    }

    @Override
    @Transactional
    public Destino cadastrar(Destino d) {
        destinosRepository.cadastrar(d);
        return destinosRepository.cadastrar(d);
    }

    @Override
    public Destino atualizar(Long idDestino, Destino destino) {
        Destino d = destinosRepository.findById(idDestino);
        d.setFotoDestino(destino.getFotoDestino());
        d.setNomeDestino(destino.getNomeDestino());
        d.setPrecoDestino(destino.getPrecoDestino());
        return d;
    }

    @Override
    public Boolean apagar(Long idDestino) {
        return destinosRepository.deleteById(idDestino);
    }
    
}
