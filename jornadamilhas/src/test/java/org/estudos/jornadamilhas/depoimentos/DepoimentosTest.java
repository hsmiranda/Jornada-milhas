package org.estudos.jornadamilhas.depoimentos;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.*;


@QuarkusTest
public class DepoimentosTest {

    @Test
    public void testDepoimentoGetEndpoint() {
        given().when().get("/depoimento").then().statusCode(200);
    }

}
      
