package com.fiap.restaurante.usecases;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import com.fiap.restaurante.controllers.exceptions.BadRequestException;
import com.fiap.restaurante.entities.RestauranteEntity;
import com.fiap.restaurante.external.persistance.entites.Reserva;
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
  public Reserva create(ReservaCreateDto dto) {
    RestauranteEntity restaurante = this.restauranteGateway.findOne(dto.restauranteId());
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    LocalDateTime horarioAtual = LocalDateTime.parse(dto.startDate(), formatter);
    boolean isSunday = horarioAtual.getDayOfWeek() == DayOfWeek.SUNDAY;
    LocalTime abertura = restaurante.getHorario().getAbertura();
    LocalTime fechamento = restaurante.getHorario().getFechamento();
    if (isSunday) {
      abertura = restaurante.getHorario().getAberturaFimDeSemana();
      fechamento = restaurante.getHorario().getFechamentoFimDeSemana();
    }
    Duration diferenca = Duration.between(horarioAtual.toLocalTime(), fechamento);
    long diferencaEmHoras = diferenca.toHours();
    Boolean afterTwoHoursFromFechamento = diferencaEmHoras >= 2;
    Boolean betweenAberturaAndFechamento = horarioAtual.toLocalTime().isAfter(abertura) && horarioAtual.toLocalTime().isBefore(fechamento);
    if (!(afterTwoHoursFromFechamento && betweenAberturaAndFechamento)) {
      throw new BadRequestException("Este horario não é válido para reservas neste restaurante");
    }
    LocalDateTime enceramento = horarioAtual.plusHours(2);
    String enceramentoString = enceramento.format(formatter);
    ReservaEntity reservaToSave = ReservaEntity.builder().startDate(dto.startDate()).expectedEndDate(enceramentoString).build();
    return this.reservaGateway.create(dto, reservaToSave);
  }

  @Override
  public List<ReservaEntity> findAll(UUID id) {

    return null;
  }
}
