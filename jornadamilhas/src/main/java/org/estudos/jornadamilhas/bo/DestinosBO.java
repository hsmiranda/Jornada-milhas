package org.estudos.jornadamilhas.bo;

import org.estudos.jornadamilhas.domain.Destino;

public class DestinosBO {

    private Destino destino;

    private boolean descritivoIsNull(Destino d) {
        if (d.getTextoDescritivoDestino().isEmpty()
                || d.getTextoDescritivoDestino().isBlank()) {
            return false;
        }
        return true;
    }


}
