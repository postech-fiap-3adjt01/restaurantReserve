//package com.fiap.restaurante.performace;
//import io.gatling.javaapi.core.ActionBuilder;
//import io.gatling.javaapi.core.ScenarioBuilder;
//import io.gatling.javaapi.core.Simulation;
//import io.gatling.javaapi.http.HttpProtocolBuilder;
//import org.springframework.http.HttpStatus;
//
//import java.time.Duration;
//
//import static io.gatling.javaapi.core.CoreDsl.*;
//import static io.gatling.javaapi.http.HttpDsl.http;
//import static io.gatling.javaapi.http.HttpDsl.status;
//
//public class PerformanceSimulation extends Simulation {
//
//  private final HttpProtocolBuilder httpProtocol =
//          http.baseUrl("http://localhost:8080")
//                  .header("Content-Type", "application/json");
//        ActionBuilder criaRestaurante = http("criar restaurante")
//                .post("restaurante")
//                .body(StringBody("{\"nome\": \"Nova Boia\"}"))
//                .check(status().is(201));
//        ScenarioBuilder cenario = scenario("criar restaurante")
//                .exec(criaRestaurante);
//
//  {
//    setUp(
//            cenario.injectOpen(
//                    rampUsersPerSec(1)
//                            .to(10)
//                            .during(Duration.ofSeconds(10)),
//                    constantUsersPerSec(10)
//                            .during(Duration.ofSeconds(20)),
//                    rampUsersPerSec(10)
//                            .to(1)
//                            .during(Duration.ofSeconds(10))
//            )
//    )
//            .protocols(httpProtocol)
//            .assertions(
//                    global().responseTime().max().lt(50)
//            );
//  }
//}
