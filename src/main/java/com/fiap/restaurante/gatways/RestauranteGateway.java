package com.fiap.restaurante.gatways;

import com.fiap.restaurante.entities.ReservaEntity;
import com.fiap.restaurante.entities.RestauranteEntity;
import com.fiap.restaurante.external.persistance.entites.Horario;
import com.fiap.restaurante.external.persistance.entites.Reserva;
import com.fiap.restaurante.external.persistance.entites.Restaurante;
import com.fiap.restaurante.external.persistance.jparepositories.HorarioJpaRepository;
import com.fiap.restaurante.external.persistance.jparepositories.ReservaJpaRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.fiap.restaurante.external.persistance.jparepositories.RestauranteJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * Restaurante gateway.
 **/
@Service
@AllArgsConstructor
public class RestauranteGateway {


  private final RestauranteJpaRepository restauranteJpaRepository;
  private final HorarioJpaRepository horarioJpaRepository;
  private final EntityManager entityManager;

  /**
   * Lista todos os restaurantes.
   **/
  public List<Restaurante> getAllRestaurantes() {
    return  this.restauranteJpaRepository.findAll();
  }

  /**
   * Cria restaurantes.
   **/
  public Restaurante save(RestauranteEntity restaurante) {
    System.out.println(restaurante.getHorario().getFechamento());
    Horario horario = Horario.builder()
            .abertura(restaurante.getHorario().getAbertura().toString())
            .aberturaFimDeSemana(restaurante.getHorario().getAberturaFimDeSemana().toString())
            .fechamento(restaurante.getHorario().getFechamento().toString())
            .fechamentoFimDeSemana(restaurante.getHorario().getFechamentoFimDeSemana().toString())
            .build();
    Horario horarioCreated = this.horarioJpaRepository.save(horario);
    Restaurante data = Restaurante
            .builder()
            .nome(restaurante.getNome())
            .cozinha((restaurante.getCozinha()))
            .capacidade(restaurante.getCapacidade())
            .localizacao(restaurante.getLocalizacao())
            .horario(horarioCreated)
            .build();

    return this.restauranteJpaRepository.save(data);
  }

  public List<Restaurante> findAll(String query) {
    String jpql = "SELECT r FROM Restaurante r " +
            "WHERE r.nome LIKE :query " +
            "OR r.cozinha LIKE :query " +
            "OR r.localizacao LIKE :query";

    // Criando a consulta tipada
    TypedQuery<Restaurante> typedQuery = entityManager.createQuery(jpql, Restaurante.class);

    // Definindo o parâmetro da consulta
    typedQuery.setParameter("query", "%" + query + "%");
    return typedQuery.getResultList();
  }
}
