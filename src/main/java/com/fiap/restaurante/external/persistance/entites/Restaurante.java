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

    public Integer capacidade;

    @OneToOne
    @JoinColumn(name = "horario_id")
    public Horario horario;

    @OneToMany(mappedBy = "restaurante")
    public List<Mesa> mesas;
}
