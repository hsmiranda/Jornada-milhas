package org.estudos.jornadamilhas.depoimentos;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTestResource(H2DatabaseTestResource.class)
public class DestinosTest {

    @Test
    public void testDestinosGetEndpoint() {
        given().when().get("/destino").then().statusCode(200);
    }
}
