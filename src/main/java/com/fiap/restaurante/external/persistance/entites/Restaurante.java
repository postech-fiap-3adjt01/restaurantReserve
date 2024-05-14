package com.fiap.restaurante.external.persistance.entites;


import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




/**
 * Entidade de Restaurante.
 **/
@Entity
@Table(name = "restaurante")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurante {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public UUID id;

  @Column(nullable = false)
  public String nome;

  @Column(nullable = false)
  public String localizacao;

  @Column(nullable = false)
  public String cozinha;

  @Column(nullable = false)
  public Integer capacidade;

  @OneToOne
  @JoinColumn(name = "horario_id")
  public Horario horario;

  @OneToMany
  @JoinColumn(name = "reserva")
  public List<Reserva> reservas;
}
