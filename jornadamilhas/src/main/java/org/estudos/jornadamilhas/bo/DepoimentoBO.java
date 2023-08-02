package org.estudos.jornadamilhas.bo;

import java.util.ArrayList;
import java.util.List;

import org.estudos.jornadamilhas.entity.Depoimento;
import org.estudos.jornadamilhas.infra.DepoimentosUtils;
import org.estudos.jornadamilhas.repository.DepoimentoRepository;


public class DepoimentoBO {
    
	public List<Depoimento> getDepoimentosHome() {

		DepoimentoRepository depoimentoRepository = new DepoimentoRepository();

		List<Depoimento> depoimentosAleatorios = new ArrayList<>();
		
		for(int i=0; i<3; i++){
			depoimentosAleatorios.add(DepoimentosUtils.getRandomDepoimento(depoimentoRepository.listAll()));
		}

		return depoimentosAleatorios;
	}
}
