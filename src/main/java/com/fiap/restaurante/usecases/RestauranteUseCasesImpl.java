package com.fiap.restaurante.usecases;

import com.fiap.restaurante.entities.HorarioEntity;
import com.fiap.restaurante.entities.ReservaEntity;
import com.fiap.restaurante.entities.RestauranteEntity;
import com.fiap.restaurante.external.persistance.entites.Restaurante;
import com.fiap.restaurante.gatways.ReservaGateway;
import com.fiap.restaurante.gatways.RestauranteGateway;
import com.fiap.restaurante.interfaces.RestauranteCreateDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Use case para registrar restaurante.
 **/
@Service
@RequiredArgsConstructor
public class RestauranteUseCasesImpl implements RestauranteUseCases {


  private final RestauranteGateway restauranteGateway;

  /**
   * método para criar restaurante.
   **/
  @Override
  public Restaurante create(RestauranteCreateDto dto) {
    HorarioEntity horario = HorarioEntity.builder()
            .abertura(dto.horarioDeAbertura())
            .fechamento(dto.horarioDeFechamento())
            .aberturaFimDeSemana((dto.horarioDeFechamentoFimDeSemana()))
            .fechamentoFimDeSemana((dto.horarioDeFechamentoFimDeSemana()));
    RestauranteEntity restaurante = RestauranteEntity.builder()
            .nome(dto.nome())
            .capacidade(dto.capacidade())
            .cozinha((dto.cozinha()))
            .horario(horario)
            .localizacao(dto.localizacao())
            .build();
    return restauranteGateway.save(restaurante);

  }

  @Override
  public List<Restaurante> findAll(String query) {
    return restauranteGateway.findAll(query);
  }

}
