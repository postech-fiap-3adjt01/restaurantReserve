package com.fiap.restaurante.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.restaurante.external.persistance.entites.Reserva;
import com.fiap.restaurante.gatways.ReservaGateway;
import com.fiap.restaurante.usecases.RestauranteUseCases;
import com.fiap.restaurante.usecases.RestauranteUseCasesImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RestauranteEntityTests {

  AutoCloseable openMocks;
  private RestauranteUseCases restauranteUseCases;

  @Mock
  private ReservaGateway reservaGateway;

  public static String asJsonString(final Object object) throws JsonProcessingException {
    return new ObjectMapper().writeValueAsString(object);
  }

  @BeforeEach
  void setup() {
    openMocks = MockitoAnnotations.openMocks(this);
//    restauranteUseCases = new RestauranteUseCasesImpl(reservaGateway);
  }

  @AfterEach
  void tearDown() throws Exception {
    openMocks.close();
  }

  @Test
  void firstTest() {
//    Reserva reserva = Reserva.builder().startDate(Date.now()).build();
//    when(reservaGateway.save(any(Reserva.class)))
////                .thenReturn(Optional.of(reserva));
//            .thenAnswer((i) -> i.getArgument(0));
//    Reserva response = reservaGateway.save(reserva);
////não fazer verificação isEqualsTO para objetos
//    assertThat(response.startDate).isEqualTo(reserva.startDate);
//    verify(reservaGateway, times(1)).save(any(Reserva.class));
  }

//  @Test
//  void test() {
//    UUID uuid = UUID.randomUUID();
//    Reserva reserva = Reserva.builder().build();
////        when(reservaGateway.getAllRestauranteReservas(uuid)).thenReturn(Optional.empty());
//    assertThatThrownBy(() -> registerReservaUseCase.registerReserva(reserva))
//            .isInstanceOf(BadRequestException.class)
//            .hasMessage("Alo");
//  }

}
