package com.fiap.restaurante.external.persistance.entites;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "horario")
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    private LocalTime abertura;

    @Column(name = "abertura_fim_de_semana")
    private LocalTime aberturaFimDeSemana;

    private LocalTime fechamento;

    @Column(name = "fechamento_fim_de_semana")
    private LocalTime fechamentoFimDeSemana;

    @OneToMany
    @JoinColumn(name = "horario_id")
    public List<Restaurante> restaurantes;
}
