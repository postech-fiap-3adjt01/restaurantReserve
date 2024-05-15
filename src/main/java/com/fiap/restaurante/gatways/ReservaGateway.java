package com.fiap.restaurante.gatways;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fiap.restaurante.controllers.exceptions.BadRequestException;
import com.fiap.restaurante.entities.RestauranteEntity;
import com.fiap.restaurante.external.persistance.entites.Restaurante;
import com.fiap.restaurante.external.persistance.entites.Usuario;
import com.fiap.restaurante.external.persistance.jparepositories.RestauranteJpaRepository;
import com.fiap.restaurante.external.persistance.jparepositories.UsuarioJpaRepository;
import com.fiap.restaurante.interfaces.ReservaCreateDto;
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
  private  final UsuarioJpaRepository usuarioJpaRepository;
  private  final RestauranteJpaRepository restauranteJpaRepository;

  /**
   * Lista reservas.
   **/
  public List<ReservaEntity> findAll(UUID restauranteId) {
    List<Reserva> reservas = this.reservaJpaRepository.findByRestauranteId(restauranteId);
    return reservas.stream()
            .map(reserva -> ReservaEntity.builder()
                    .startDate(reserva.getStartDate().toString())
                    .endDate(reserva.getEndDate().toString())
                    .expectedEndDate(reserva.getExpectedEndDate().toString()))
                    .toList();
  }

  /**
   * Cria reserva.
   **/
  public Reserva create(ReservaCreateDto dto, ReservaEntity reserva) {
    Optional<Restaurante> restaurante = this.restauranteJpaRepository.findById(dto.restauranteId());
    if (restaurante.isEmpty()) {
      throw new BadRequestException("Este restaurante não está no nosso banco de dados");
    }
    Optional<Usuario> usuario = this.usuarioJpaRepository.findById(dto.usuarioId());
    if (usuario.isEmpty()) {
      throw new BadRequestException("Este usuário não está no nosso banco de dados");
    }
    Reserva reservaToSave = Reserva.builder()
            .startDate(reserva.getStartDate())
            .expectedEndDate(reserva.getExpectedEndDate())
            .restaurante(restaurante.get())
            .usuario(usuario.get())
            .build();
    return this.reservaJpaRepository.save(reservaToSave);
  }
}
