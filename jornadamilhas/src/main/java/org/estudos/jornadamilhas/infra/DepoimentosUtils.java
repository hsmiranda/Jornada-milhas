package org.estudos.jornadamilhas.infra;

import java.util.List;
import java.util.Random;

import org.estudos.jornadamilhas.entity.Depoimento;

public class DepoimentosUtils {

    public static Depoimento getRandomDepoimento(List<Depoimento> l) {
        // deepcode ignore ReuseRandom: <please specify a reason of ignoring this>
        Random rand = new Random();
        return l.get(rand.nextInt(l.size()));
    }
}
