package org.estudos.jornadamilhas.depoimentos;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.*;

@QuarkusTest
public class DestinosTest {

    @Test
    public void testDestinosGetEndpoint() {
        given().when().get("/destino").then().statusCode(200);
    }

}
