package com.fiap.restaurante.entity;
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

    @OneToMany(mappedBy = "usuario")
    public List<Reserva> reservaList;
}
