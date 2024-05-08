package com.fiap.restaurante.interfaces;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RestauranteCreateDto(
        @NotBlank(message = "O campo nome deve ser preenchido. ")
        String nome,
        @NotBlank(message = "O campo localizacao deve ser preenchido. ")
        String localizacao,
        @NotBlank(message = "O campo cozinha deve ser preenchido. ")
        String cozinha,
        @NotBlank(message = "O campo horario deve ser preenchido")
        String horario,
        @NotNull(message = "O campo capacidade deve ser preenchido")
        Integer capacidade
        ) {}
