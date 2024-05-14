package com.fiap.restaurante.entities;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade de Reserva.
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaEntity {
  private LocalDateTime startDate;
  private LocalDateTime expectedEndDate;
  private LocalDateTime endDate;

  public static ReservaEntity builder() {
    return new ReservaEntity();
  }

  public ReservaEntity build() {
    return this;
  }

  public ReservaEntity startDate(String time) {
    this.startDate = this.convertTime(time);
    return this;
  }

  public ReservaEntity expectedEndDate(String time) {
    this.expectedEndDate = this.convertTime(time);
    return this;
  }

  public ReservaEntity endDate(String time) {
    this.endDate = this.convertTime(time);
    return this;
  }

  private LocalDateTime convertTime(String time) {
    return LocalDateTime.parse(time);
  }
}
