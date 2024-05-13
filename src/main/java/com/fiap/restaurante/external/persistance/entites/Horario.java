package com.fiap.restaurante.external.persistance.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalTime;
import java.util.UUID;
import lombok.*;

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
  @NotEmpty(message = "Um horário deve ter o campo abertura preenchido")
  private String abertura;

  @Column(name = "abertura_fim_de_semana", nullable = false)
  @NotEmpty(message = "Um horário deve ter o campo abertura_fim_de_semana preenchido")
  private String aberturaFimDeSemana;

  @Column(nullable = false)
  @NotEmpty(message = "Um horário deve ter o campo fechamento preenchido")
  private String fechamento;

  @Column(name = "fechamento_fim_de_semana", nullable = false)
  @NotEmpty(message = "Um horário deve ter o campo fechamento_fim_de_semana preenchido")
  private String fechamentoFimDeSemana;
}
