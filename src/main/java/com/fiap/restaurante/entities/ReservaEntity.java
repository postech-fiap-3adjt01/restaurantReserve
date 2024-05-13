package com.fiap.restaurante.entities;

import java.time.LocalDateTime;


public class ReservaEntity {
        public LocalDateTime startDate;
        public LocalDateTime expectedEndDate;
        public LocalDateTime endDate;

    public ReservaEntity(
            LocalDateTime startDate,
            LocalDateTime expectedEndDate,
            LocalDateTime endDate

    ) {
        this.startDate = startDate;
        this.expectedEndDate = expectedEndDate;
        this.endDate = endDate;
    }

}
