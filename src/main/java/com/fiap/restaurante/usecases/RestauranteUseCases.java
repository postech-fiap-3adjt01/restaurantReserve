package com.fiap.restaurante.usecases;

import com.fiap.restaurante.entities.RestauranteEntity;
import com.fiap.restaurante.external.persistance.entites.Restaurante;
import com.fiap.restaurante.interfaces.RestauranteCreateDto;

import java.util.List;

/**
 * Use case para restaurante.
 **/
public interface RestauranteUseCases {

  Restaurante create(RestauranteCreateDto reservaEntity);
  List<Restaurante> findAll(String query);
}
