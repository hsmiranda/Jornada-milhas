package org.estudos.jornadamilhas.services.impl;

import java.util.List;

import org.estudos.jornadamilhas.domain.Destino;
import org.estudos.jornadamilhas.repository.DestinosRepository;
import org.estudos.jornadamilhas.services.DestinoService;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class DestinoServiceImpl implements DestinoService {

    @Inject
    private DestinosRepository destinosRepository;

    @Override
    public List<Destino> listarTodos() {
        return this.destinosRepository.listAll();
    }

    @Override
    @Transactional
    public Destino cadastrar(Destino d) {
        this.destinosRepository.cadastrar(d);
        return destinosRepository.cadastrar(d);
    }

    @Override
    @Transactional
    public Destino atualizar(Long idDestino, Destino destino) {
        Destino d = this.destinosRepository.findById(idDestino);
        d.setFotoDestino(destino.getFotoDestino());
        d.setNomeDestino(destino.getNomeDestino());
        d.setPrecoDestino(destino.getPrecoDestino());
        return d;
    }

    @Override
    @Transactional
    public Boolean apagar(Long idDestino) {
        return this.destinosRepository.deleteById(idDestino);
    }

    @Override
    @Transactional
    public Destino findById(Long id){
        Destino d = this.destinosRepository.findById(id);

        if (d == null){
            Log.info("Destino nao encontrado");
            throw new NotFoundException("Destino nAo localizado");
        }

        return d;
    }
    
}
