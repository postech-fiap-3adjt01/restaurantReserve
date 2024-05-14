package com.fiap.restaurante.usecases;

import com.fiap.restaurante.entities.RestauranteEntity;
import com.fiap.restaurante.interfaces.RestauranteCreateDto;
import java.util.List;

/**
 * Use case para restaurante.
 **/
public interface RestauranteUseCases {

  RestauranteEntity create(RestauranteCreateDto reservaEntity);
  List<RestauranteEntity> findAll(String query);
}
