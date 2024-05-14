package com.fiap.restaurante.usecases;

import com.fiap.restaurante.entities.ReservaEntity;
import com.fiap.restaurante.interfaces.ReservaCreateDto;

import java.util.List;
import java.util.UUID;

public interface ReservaUseCases {

  ReservaEntity create(ReservaCreateDto dto);
  List<ReservaEntity> findAll(UUID id);
}
