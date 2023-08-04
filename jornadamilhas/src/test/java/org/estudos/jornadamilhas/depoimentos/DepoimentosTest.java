package org.estudos.jornadamilhas.depoimentos;

import org.estudos.jornadamilhas.entity.Depoimento;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.json.JsonObject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import static io.restassured.RestAssured.*;


@QuarkusTest
public class DepoimentosTest {

    @Test
    public void testDepoimentoGetEndpoint() {
        given().when().get("/depoimento").then().statusCode(200);
    }

    @Test
    public void testeDepoimentoPostEndpoint(){

        //  requestParams.put("nome", "Carlos aberto");
        //  requestParams.put("textoDepoimento", "Que viagem incrivel, so que a cidade tinha um contador ruim de piadas");

        //    write().body(requestParams.toJSONString()).
        //     when().
        //     post("/depoimento").
        //     then().
        //     statusCode(201);

    }

}
      
