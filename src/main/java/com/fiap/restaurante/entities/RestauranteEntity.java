package com.fiap.restaurante.entities;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade de Restaurante.
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteEntity {
  @NotEmpty(message = "Um restaurante deve ter o campo nome preenchido")
  private String nome;

  private String localizacao;
  @NotEmpty(message = "Um restaurante deve ter o campo cozinha preenchido")
  private String cozinha;
  @NotNull(message = "Um restaurante deve ter o campo capacidade preenchido")
  private Integer capacidade;
  @NotEmpty(message = "Um restaurante deve ter sempre um horario preenchido")
  private HorarioEntity horario;
}