package org.estudos.jornadamilhas.infra;

import org.estudos.jornadamilhas.depoimentos.Depoimento;

import java.util.List;
import java.util.Random;

public class RandomUtils {

    Random rand = new Random() ;
    public Depoimento getRandomDepoimento(List<Depoimento> l) {
        return l.get(this.rand.nextInt(l.size()));
    }
}
