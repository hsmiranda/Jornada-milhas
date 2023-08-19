package org.estudos.jornadamilhas.depoimentos;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.quarkus.logging.Log;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import org.estudos.jornadamilhas.infra.ia.ChatGPTUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTestResource(H2DatabaseTestResource.class)
public class DestinosTest {

    @Test
    public void testDestinosGetEndpoint() {
        given().when().get("/destino").then().statusCode(200);
    }

    @Test
    public void testeChatGPT() throws JsonProcessingException {
        ChatGPTUtils chatGPTUtils = new ChatGPTUtils();
        Log.info(chatGPTUtils.generateText("Mensagem"));
    }

}
