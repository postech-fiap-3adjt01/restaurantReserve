package com.fiap.restaurante.external.persistance.entites;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reserva")
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @Column(name = "start_date")
    public LocalDateTime startDate;

    @Column(name = "expected_end_date")
    public LocalDateTime expectedEndDate;

    @Column(name = "end_date")
    public LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "mesa_id")
    public Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    public Usuario usuario;
}
