package com.fiap.restaurante.external.persistance.entites;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "usuario")
@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    public String email;

    public String nome;

    @OneToMany(mappedBy = "usuario_id")
    public List<Reserva> reservas;

    @OneToMany(mappedBy = "usuario_id")
    public List<Comentario> comentarios;
}
