package org.estudos.jornadamilhas.depoimentos;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import org.estudos.jornadamilhas.domain.Depoimento;
import org.estudos.jornadamilhas.repository.DepoimentoRepository;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.*;


@QuarkusTestResource(H2DatabaseTestResource.class)
public class DepoimentosTest {

    @Test
    public void testDepoimentoGetEndpoint() {
        given().when().get("/depoimento").then().statusCode(200);
    }

    @Test
    public void testDepoimentoGetByIdEndpoint(){
        Depoimento d = new DepoimentoRepository().getPrimeiro();
        String param = "/depoimento/"+d.getId();
        given().when().get(param).then().statusCode(200);
    }

}
      
