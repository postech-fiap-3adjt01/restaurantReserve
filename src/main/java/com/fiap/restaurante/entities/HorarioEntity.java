package com.fiap.restaurante.entities;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class HorarioEntity {
    private LocalTime abertura;
    private LocalTime aberturaFimDeSemana;
    private LocalTime fechamento;
    private LocalTime fechamentoFimDeSemana;

    public HorarioEntity(
            String abertura,
            String aberturaFimDeSemana,
            String fechamento,
            String fechamentoFimDeSemana) {
         this.abertura = this.convertTime(abertura);
         this.aberturaFimDeSemana = this.convertTime(aberturaFimDeSemana);
         this.fechamento = this.convertTime(fechamento);
         this.fechamentoFimDeSemana = this.convertTime(fechamentoFimDeSemana);

    }

    private LocalTime convertTime(String time) {
        return LocalTime.parse(time);
    }
}
