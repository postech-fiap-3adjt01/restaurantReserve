package com.fiap.restaurante.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "restaurante")
@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
    public String nome;
    public String localizacao;
    public String cozinha;
    public String horario;
    public Integer capacidade;
}
