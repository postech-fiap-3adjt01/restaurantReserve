package com.fiap.restaurante.gatways;

import com.fiap.restaurante.entities.HorarioEntity;
import com.fiap.restaurante.entities.RestauranteEntity;
import com.fiap.restaurante.external.persistance.entites.Restaurante;


/**
 * Converte um restaurante vindo da database para a entidade de dominio.
 **/
public class RestauranteDatabaseToDomain {

  /**
   * Executa a classe.
   **/
  public static RestauranteEntity exec(Restaurante restaurante) {
    HorarioEntity horarioEntity = HorarioEntity.builder()
            .abertura(restaurante.getHorario().getAbertura())
            .aberturaFimDeSemana(restaurante.getHorario().getAberturaFimDeSemana())
            .fechamento(restaurante.getHorario().getFechamento())
            .fechamentoFimDeSemana(restaurante.getHorario().getFechamentoFimDeSemana())
            .build();

    return RestauranteEntity
            .builder()
            .nome(restaurante.getNome())
            .cozinha((restaurante.getCozinha()))
            .capacidade(restaurante.getCapacidade())
            .localizacao(restaurante.getLocalizacao())
            .horario(horarioEntity)
            .build();
  }
}
