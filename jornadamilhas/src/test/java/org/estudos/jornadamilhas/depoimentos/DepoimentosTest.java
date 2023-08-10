package org.estudos.jornadamilhas.depoimentos;

import org.estudos.jornadamilhas.domain.Depoimento;
import org.estudos.jornadamilhas.repository.DepoimentoRepository;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.*;


@QuarkusTest
public class DepoimentosTest {

    @Test
    public void testDepoimentoGetEndpoint() {
        given().when().get("/depoimento").then().statusCode(200);
    }

    @Test
    public void testDepoimentoGetByIdEndpoint(){
        Depoimento d = new DepoimentoRepository().getPrimeiro();
        String parametro = "/depoimento/"+d.getId();
        given().when().get(parametro).then().statusCode(200);
    }

}
      
