package com.fiap.restaurante.interfaces;

import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

/**
 * Record para criar uma nova reserva.
 **/
public record ReservaCreateDto(
        @NotEmpty(message = " O campo startDate não pode estar em branco")
        String startDate,
        @NotEmpty(message = " O campo restauranteId não pode estar em branco")
        UUID restauranteId,
        @NotEmpty(message = " O campo usuarioId não pode estar em branco")
        UUID usuarioId
) {
}
