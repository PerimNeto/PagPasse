
package model;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;

import static org.hamcrest.Matchers.*;

class RecargaApiTest {

    @Container
    static GenericContainer<?> app = new GenericContainer<>("eclipse-temurin:21-jdk-jammy")
            .withExposedPorts(8080);

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    @DisplayName("Deve recusar recarga com valor negativo")
    void deveRecusarRecargaValorNegativo() {
        String requestBody = """
            {
                "valorRecarga": -10.0,
                "metodoPagamento": "CartaoCredito",
                "dataRecarga": "2024-04-10",
                "status": true
            }
        """;

        RestAssured.given()
                .auth()
                .preemptive()
                .basic("user", "password")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/recarga/adicionar")
                .then()
                .statusCode(400);
    }
}
