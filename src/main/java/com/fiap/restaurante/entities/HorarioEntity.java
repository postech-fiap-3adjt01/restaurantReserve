package com.fiap.restaurante.entities;


import jakarta.validation.constraints.NotEmpty;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.coyote.BadRequestException;

/**
 * Entidade de Horario.
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorarioEntity {
  private LocalTime abertura;
  private LocalTime aberturaFimDeSemana;
  private LocalTime fechamento;
  private LocalTime fechamentoFimDeSemana;

  public static HorarioEntity builder() {
    return new HorarioEntity();
  }

  public HorarioEntity build() {
    return this;
  }

  public  HorarioEntity abertura(String time) {
    this.abertura = this.convertTime(time);
    return this;
  }

  public HorarioEntity aberturaFimDeSemana(String time) {
    this.aberturaFimDeSemana = this.convertTime(time);
    return this;
  }

  public HorarioEntity fechamento(String time) {
    this.fechamento = this.convertTime(time);
    return this;
  }

  public HorarioEntity fechamentoFimDeSemana(String time) {
    this.fechamentoFimDeSemana = this.convertTime(time);
    return this;
  }

  private LocalTime convertTime(String time) {
    return LocalTime.parse(time);
  }
}
