package com.fiap.restaurante.usecases;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fiap.restaurante.entities.ReservaEntity;
import com.fiap.restaurante.gatways.ReservaGateway;
import com.fiap.restaurante.gatways.RestauranteGateway;
import com.fiap.restaurante.interfaces.ReservaCreateDto;

import lombok.RequiredArgsConstructor;

/**
 * Use case para Reservas.
 **/
@Service
@RequiredArgsConstructor
public class ReservaUseCasesImpl implements ReservaUseCases {

  private final ReservaGateway reservaGateway;

  private final RestauranteGateway restauranteGateway;


  @Override
  public ReservaEntity create(ReservaCreateDto dto) {
//    RestauranteEntity restaurante = this.restauranteGateway.findOne(dto.restauranteId());
//    LocalDateTime date = new LocalDateTime(dto.startDate());
//    boolean isSunday = date.getDayOfWeek() == DayOfWeek.SUNDAY;

    return null;
  }

  @Override
  public List<ReservaEntity> findAll(UUID id) {

    return null;
  }
}
