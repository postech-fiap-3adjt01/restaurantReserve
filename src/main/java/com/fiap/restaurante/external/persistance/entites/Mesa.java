package com.fiap.restaurante.external.persistance.entites;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "mesa")
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    public Restaurante restaurante;

    @OneToMany(mappedBy = "mesa_id")
    public List<Reserva> reservas;

}
