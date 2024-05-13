package com.fiap.restaurante.gatways;

import com.fiap.restaurante.entities.ReservaEntity;
import com.fiap.restaurante.external.persistance.entites.Reserva;
import com.fiap.restaurante.external.persistance.jparepositories.ReservaJpaRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


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
  public List<ReservaEntity> getAllRestauranteReservas(UUID restauranteId) {
    List<Reserva> reservas = this.reservaJpaRepository.findByRestauranteId(restauranteId);
    return reservas.stream()
            .map(reserva -> new ReservaEntity(
                    reserva.getStartDate(),
                    reserva.getExpectedEndDate(),
                    reserva.getEndDate()
            ))
            .collect(Collectors.toList());
  }

  public Reserva save(Reserva reserva) {
    return this.reservaJpaRepository.save(reserva);
  }
}
