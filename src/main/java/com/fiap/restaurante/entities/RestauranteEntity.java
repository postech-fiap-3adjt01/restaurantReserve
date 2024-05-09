package com.fiap.restaurante.entities;

import java.time.LocalDateTime;

public class RestauranteEntity {
    private String nome;
    private String localizacao;
    private  String cozinha;
    private Integer capacidade;
    private HorarioEntity horario;

    public RestauranteEntity(
            String nome,
            String localizacao,
            String cozinha,
            Integer capacidade,
            HorarioEntity horario) {
       this.nome = nome;
       this.localizacao = localizacao;
       this.cozinha = cozinha;
       this.capacidade = capacidade;
       this.horario = horario;
    }
}