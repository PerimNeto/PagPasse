package model;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class CartaoTransporteApiTest {
    private static String BASE_URL = System.getProperty("app.url", "http://localhost:8080");

    @BeforeEach
    void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    @DisplayName("Deve cadastrar um novo Cartão de Transporte com sucesso")
    void deveCadastrarCartaoComSucesso() {
        String requestBody = """
            {
                "numeroCartao": 1234567890,
                "tipoCartao": "Comum",
                "saldoCartao": 50.0,
                "dataEmissao": "2024-04-01"
            }
        """;

        RestAssured.given()
                .auth()
                .preemptive()
                .basic("user", "password")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/cartao-transporte/adicionar")
                .then()
                .statusCode(200)
                .body("numeroCartao", equalTo(1234567890))
                .body(matchesJsonSchemaInClasspath("schemas/CartaoTransporteSchema.json"));
    }
}

