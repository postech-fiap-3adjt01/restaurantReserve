package com.fiap.restaurante.external.persistance.entites;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.UUID;
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
  @NotEmpty(message = "Uma reserva deve ter o campo start_date preenchido")
  public LocalDateTime startDate;

  @Column(name = "expected_end_date", nullable = false)
  @NotEmpty(message = "Uma reserva deve ter o campo start_date preenchido")
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
