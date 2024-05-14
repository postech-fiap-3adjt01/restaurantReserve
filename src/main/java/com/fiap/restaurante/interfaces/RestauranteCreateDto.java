package com.fiap.restaurante.interfaces;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * Record de RestauranteCreateDto.
 **/
public record RestauranteCreateDto(
        @NotEmpty(message = "Um restaurante deve ter o campo nome preenchido")
        String nome,
        @NotEmpty(message = "Um restaurante deve ter o campo localizacao preenchido")
        String localizacao,
        @NotEmpty(message = "Um restaurante deve ter o campo cozinha preenchido")
        String cozinha,
        @NotNull(message = "Um restaurante deve ter o campo capacidade preenchido")
        Integer capacidade,
        @NotEmpty(message = "Um restaurante deve ter o campo horarioDeAbertura preenchido")
        String horarioDeAbertura,
        @NotEmpty(message = "Um restaurante deve ter o campo horarioDeAberturaDeFimDeSemana")
        String horarioDeAberturaFimDeSemana,
        @NotEmpty(message = "Um restaurante deve ter o campo horarioDeFechamento preenchido")
        String horarioDeFechamento,
        @NotEmpty(message = "Um restaurante deve ter o campo horarioDeFechamentoFimDeSemana")
        String horarioDeFechamentoFimDeSemana
) {
}
