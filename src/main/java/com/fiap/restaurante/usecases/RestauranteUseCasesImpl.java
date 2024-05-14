package com.fiap.restaurante.usecases;

import com.fiap.restaurante.entities.HorarioEntity;
import com.fiap.restaurante.entities.RestauranteEntity;
import com.fiap.restaurante.external.persistance.entites.Restaurante;
import com.fiap.restaurante.gatways.RestauranteGateway;
import com.fiap.restaurante.interfaces.RestauranteCreateDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Use case para restaurante.
 **/
@Service
@RequiredArgsConstructor
public class RestauranteUseCasesImpl implements RestauranteUseCases {


  private final RestauranteGateway restauranteGateway;

  /**
   * método para criar restaurante.
   **/
  @Override
  public RestauranteEntity create(RestauranteCreateDto dto) {
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
  public List<RestauranteEntity> findAll(String query) {
    return restauranteGateway.findAll(query);
  }

}
