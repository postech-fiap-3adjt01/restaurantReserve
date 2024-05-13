package com.fiap.restaurante.external.persistance.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade de Usurario.
 **/
@Entity
@Table(name = "usuario")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public UUID id;

  @Column(nullable = false)
  @NotEmpty(message = "Um Usuario deve ter o campo email preenchido")
  public String email;

  @Column(nullable = false)
  @NotEmpty(message = "Um Usuario deve ter o campo nome preenchido")
  public String nome;

  @OneToMany(mappedBy = "usuario")
  public List<Reserva> reservas;

  @OneToMany(mappedBy = "usuario")
  public List<Comentario> comentarios;
}