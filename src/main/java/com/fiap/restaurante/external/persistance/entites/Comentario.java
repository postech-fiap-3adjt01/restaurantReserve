package com.fiap.restaurante.external.persistance.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Entidade de comentarios feito pelo usuário.
 **/
@Entity
@Table(name = "comentario")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class Comentario {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public UUID id;

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  public Usuario usuario;

  @ManyToOne
  @JoinColumn(name = "restaurante_id")
  public Restaurante restaurante;
}
