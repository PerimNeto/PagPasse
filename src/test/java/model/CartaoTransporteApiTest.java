package model;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

@Testcontainers
public class CartaoTransporteApiTest {

    @Container
    static GenericContainer<?> app = new GenericContainer<>("eclipse-temurin:21-jdk-jammy")
            .withExposedPorts(8080);

    @BeforeAll
    static void setup() {
        Integer mappedPort = app.getMappedPort(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = mappedPort;
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
