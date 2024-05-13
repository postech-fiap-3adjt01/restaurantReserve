package com.fiap.restaurante.interfaces;


/**
 * Record de RestauranteCreateDto.
 **/
public record RestauranteCreateDto(
        String nome,
        String localizacao,
        String cozinha,
        String horario,
        Integer capacidade,
        String horarioDeAbertura,
        String horarioDeAberturaFimDeSemana,
        String horarioDeFechamento,
        String horarioDeFechamentoFimDeSemana
) {
}
