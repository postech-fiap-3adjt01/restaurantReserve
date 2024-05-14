package com.fiap.restaurante.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Entidade de Restaurante.
 **/
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class RestauranteEntity {
  private String nome;
  private String localizacao;
  private String cozinha;
  private Integer capacidade;
  private HorarioEntity horario;
}