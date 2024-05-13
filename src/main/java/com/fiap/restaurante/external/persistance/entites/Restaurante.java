package com.fiap.restaurante.external.persistance.entites;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
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
  @NotEmpty(message = "Um restaurante deve ter o campo nome preenchido")
  public String nome;

  @Column(nullable = false)
  @NotEmpty(message = "Um restaurante deve ter o campo localização preenchido")
  public String localizacao;

  @Column(nullable = false)
  @NotEmpty(message = "Um restaurante deve ter o campo cozinha preenchido")
  public String cozinha;

  @Column(nullable = false)
  @NotNull(message = "Um restaurante deve ter o campo capacidade preenchido")
  public Integer capacidade;

  @OneToOne
  @JoinColumn(name = "horario_id")
  public Horario horario;

  @OneToMany
  @JoinColumn(name = "reserva")
  public List<Reserva> reservas;
}
