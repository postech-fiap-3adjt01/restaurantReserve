package com.fiap.restaurante.external.persistance.entites;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade de horario de abertura do Restaurante.
 **/
@Entity
@Table(name = "horario")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Horario {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public UUID id;

  @Column(nullable = false)
  private String abertura;

  @Column(name = "abertura_fim_de_semana", nullable = false)
  private String aberturaFimDeSemana;

  @Column(nullable = false)
  private String fechamento;

  @Column(name = "fechamento_fim_de_semana", nullable = false)
  private String fechamentoFimDeSemana;
}
