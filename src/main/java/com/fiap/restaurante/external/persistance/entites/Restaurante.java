package com.fiap.restaurante.external.persistance.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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

    @OneToMany(mappedBy = "restaurante_id")
    public List<Mesa> mesas;
}
