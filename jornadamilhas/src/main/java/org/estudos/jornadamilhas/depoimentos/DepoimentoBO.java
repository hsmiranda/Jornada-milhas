package org.estudos.jornadamilhas.depoimentos;

import org.estudos.jornadamilhas.infra.RandomUtils;

import java.util.ArrayList;
import java.util.List;


public class DepoimentoBO {
    
	public List<Depoimento> getDepoimentosHome() {

		RandomUtils depoimentosUtils = new RandomUtils();
		DepoimentoRepository depoimentoRepository = new DepoimentoRepository();

		List<Depoimento> depoimentosAleatorios = new ArrayList<>();
		
		for(int i = 0; 3 > i; i++){
			depoimentosAleatorios.add(depoimentosUtils.getRandomDepoimento(depoimentoRepository.listAll()));
		}

		return depoimentosAleatorios;
	}
}