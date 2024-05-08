package com.fiap.restaurante.external.persistance.entites;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "mesa")
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;


    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    public Restaurante restaurante;

}
