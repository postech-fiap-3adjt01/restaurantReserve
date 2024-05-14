package com.fiap.restaurante.gatways;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fiap.restaurante.entities.ReservaEntity;
import com.fiap.restaurante.external.persistance.entites.Reserva;
import com.fiap.restaurante.external.persistance.jparepositories.ReservaJpaRepository;

import lombok.AllArgsConstructor;


/**
 * Reserva gateway.
 **/
@Service
@AllArgsConstructor
public class ReservaGateway {


  private final ReservaJpaRepository reservaJpaRepository;

  /**
   * Lista reservas.
   **/
  public List<ReservaEntity> findAll(UUID restauranteId) {
    List<Reserva> reservas = this.reservaJpaRepository.findByRestauranteId(restauranteId);
    return reservas.stream()
            .map(reserva -> new ReservaEntity(
                    reserva.getStartDate(),
                    reserva.getExpectedEndDate(),
                    reserva.getEndDate()
            )).toList();
  }

  public Reserva create(Reserva reserva) {
    return this.reservaJpaRepository.save(reserva);
  }
}
