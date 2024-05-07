package com.fiap.restaurante.entity;


import ch.qos.logback.core.net.server.Client;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "reservaMesa")
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor

public class ReservaMesa {
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
    @JoinColumn(name = "restaurante_id")
    public Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "client_id")
    public Client client;
}
