package org.estudos.jornadamilhas.infra;

import java.util.List;
import java.util.Random;

import org.estudos.jornadamilhas.domain.Depoimento;

public class RandomUtils {

    Random rand = new Random() ;

    public Depoimento getRandomDepoimento(List<Depoimento> l) {
        return l.get(this.rand.nextInt(l.size()));
    }
}
