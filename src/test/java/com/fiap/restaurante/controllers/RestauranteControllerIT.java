package com.fiap.restaurante.controllers;

import com.fiap.restaurante.external.persistance.entites.Restaurante;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class RestauranteControllerIT {
  @LocalServerPort
  private int port;

  @BeforeEach
  void setup() {
    RestAssured.port = port;
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
  }

  @Test
  void testaSePodemosCriarReserva() {
    given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
//            pode passar o objeto de forma direta
            .body(Restaurante.builder().build())
            .log().all()
            .when()
            .post("restaurante")
            .then()
            .log().all()
            .statusCode(HttpStatus.OK.value())
            .body("$", hasKey("timestamp"));
  }

}
