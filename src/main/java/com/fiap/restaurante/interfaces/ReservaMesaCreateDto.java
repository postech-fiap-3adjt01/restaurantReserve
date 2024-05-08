package com.fiap.restaurante.interfaces;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;
public record ReservaMesaCreateDto(
        @NotNull(message = " O campo startDate não pode estar em branco")
                                   LocalDateTime startDate,
                                   @NotNull(message = " O campo expectedEndDate não pode estar em branco")
                                   LocalDateTime expectedEndDate,
                                   UUID restauranteId,
                                   UUID usuarioId) {
}
