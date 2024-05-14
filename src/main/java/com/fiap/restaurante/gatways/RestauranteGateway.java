package com.fiap.restaurante.gatways;

import com.fiap.restaurante.controllers.exceptions.ControllerNotFoundException;
import com.fiap.restaurante.entities.HorarioEntity;
import com.fiap.restaurante.entities.RestauranteEntity;
import com.fiap.restaurante.external.persistance.entites.Horario;
import com.fiap.restaurante.external.persistance.entites.Restaurante;
import com.fiap.restaurante.external.persistance.jparepositories.HorarioJpaRepository;

import java.util.List;
import java.util.Optional;
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
    return this.restauranteJpaRepository.findAll();
  }

  /**
   * Cria restaurantes.
   **/
  public RestauranteEntity save(RestauranteEntity restaurante) {
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
    Restaurante restauranteSaved = this.restauranteJpaRepository.save(data);
    return convertDatabaseToDomain(restauranteSaved);

  }

  /**
   * Encontra um restaurante por id.
   **/
  public RestauranteEntity findOne(UUID id) {
    Optional<Restaurante> restaurante = this.restauranteJpaRepository.findById(id);
    if (restaurante.isEmpty()) {
      throw new ControllerNotFoundException("Não tem um restaurante com este id");
    }
    return this.convertDatabaseToDomain(restaurante.get());
  }

  /**
   * Lista restaurantes.
   **/
  public List<RestauranteEntity> findAll(String query) {
    List<Restaurante> restaurantes = null;

    if (query != null && !query.isEmpty()) {
      restaurantes = this.getSearchedRestaurantes(query);
    } else {
      restaurantes = restauranteJpaRepository.findAll();
    }
    return restaurantes.stream()
            .map(this::convertDatabaseToDomain)
            .collect(Collectors.toList());
  }

  /**
   * Lista restaurantes a partir da query.
   **/
  @SuppressWarnings("checkstyle:OperatorWrap")
  public List<Restaurante> getSearchedRestaurantes(String query) {
    String jpql = "SELECT r FROM Restaurante r " +
            "WHERE r.nome LIKE :query " +
            "OR r.cozinha LIKE :query " +
            "OR r.localizacao LIKE :query";
    TypedQuery<Restaurante> typedQuery = entityManager.createQuery(jpql, Restaurante.class);

    typedQuery.setParameter("query", "%" + query + "%");
    return typedQuery.getResultList();
  }

  /**
   * Converte os resultados da database para domain.
   **/
  private RestauranteEntity convertDatabaseToDomain(Restaurante restaurante) {
    HorarioEntity horarioEntity = HorarioEntity.builder()
            .abertura(restaurante.getHorario().getAbertura())
            .aberturaFimDeSemana(restaurante.getHorario().getAberturaFimDeSemana())
            .fechamento(restaurante.getHorario().getFechamento())
            .fechamentoFimDeSemana(restaurante.getHorario().getFechamentoFimDeSemana())
            .build();

    return RestauranteEntity
            .builder()
            .nome(restaurante.getNome())
            .cozinha((restaurante.getCozinha()))
            .capacidade(restaurante.getCapacidade())
            .localizacao(restaurante.getLocalizacao())
            .horario(horarioEntity)
            .build();
  }
}
