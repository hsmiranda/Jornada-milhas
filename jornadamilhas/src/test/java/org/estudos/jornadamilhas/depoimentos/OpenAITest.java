package org.estudos.jornadamilhas.depoimentos;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import org.estudos.jornadamilhas.ia.OpenAIService;
import org.junit.jupiter.api.Test;

@QuarkusTestResource(H2DatabaseTestResource.class)
public class OpenAITest {

    @Test
    public void connectOpenAITest() {
        OpenAIService openAIService = new OpenAIService();
        String retorno = openAIService.generateText("ChatGPT qual a sua versão ?");
        assert retorno != null;
    }
}
