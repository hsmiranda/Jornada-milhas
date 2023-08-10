package org.estudos.jornadamilhas.dto;

import java.math.BigDecimal;
import org.estudos.jornadamilhas.domain.Destino;

public record DestinoDTO(String nomeDestino, BigDecimal precoDestino, Byte fotoDestino) {

    public Destino toDestino(DestinoDTO destinoDTO){
        Destino destino = new Destino();
        destino.setNomeDestino(destinoDTO.nomeDestino);
        destino.setPrecoDestino(destinoDTO.precoDestino);
        destino.setFotoDestino(destinoDTO.fotoDestino);
        return destino;
    }

    public DestinoDTO toDestinoDTO(Destino d){
        return new DestinoDTO(d.getNomeDestino(), d.getPrecoDestino(), d.getFotoDestino());
    }

}
