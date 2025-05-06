package model;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;

class AutenticacaoApiTest {

    @Container
    static GenericContainer<?> app = new GenericContainer<>("eclipse-temurin:21-jdk-jammy")
            .withExposedPorts(8080);

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    @DisplayName("Deve bloquear acesso a endpoint privado sem autenticação")
    void deveBloquearAcessoSemToken() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/private/hello")
                .then()
                .statusCode(401);
    }
}
