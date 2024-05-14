package com.fiap.restaurante.external.persistance.entites;


import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;





/**
 * Entidade de reservas.
 **/
@Entity
@Table(name = "reserva")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public UUID id;

  @Column(name = "start_date", nullable = false)
  public LocalDateTime startDate;

  @Column(name = "expected_end_date", nullable = false)
  public LocalDateTime expectedEndDate;

  @Column(name = "end_date")
  public LocalDateTime endDate;

  @ManyToOne
  @JoinColumn(name = "restaurante_id")
  public Restaurante restaurante;

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  public Usuario usuario;
}
