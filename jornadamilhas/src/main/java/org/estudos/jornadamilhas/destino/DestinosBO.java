package org.estudos.jornadamilhas.destino;

import jakarta.enterprise.context.ApplicationScoped;
import org.estudos.jornadamilhas.ia.OpenAIService;

@ApplicationScoped
public class DestinosBO {

    public Destino descritivoIsNull(Destino d) {
        if (d.getTextoDescritivoDestino() == null
                || d.getTextoDescritivoDestino().isEmpty()
                || d.getTextoDescritivoDestino().isBlank()) {

            d = getNewDescFromChatGPT(d);
        }
        return d;
    }


    private Destino getNewDescFromChatGPT(Destino d) {

        OpenAIService openAIService = new OpenAIService();

        String promptBase = "Crei um resumo sobre a cidade: " + d.getNomeDestino()
                + " enfatizando o porque este lugar é incrível. Utilize uma linguagem informal e até 100 caracteres "
                + "no máximo em cada parágrafo. Crie 2 parágrafos neste resumo.";

        d.setTextoDescritivoDestino(openAIService.generateText(promptBase));

        return d;

    }
}
