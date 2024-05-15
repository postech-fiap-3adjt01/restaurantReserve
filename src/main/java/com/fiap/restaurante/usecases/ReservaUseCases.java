package com.fiap.restaurante.usecases;

import com.fiap.restaurante.entities.ReservaEntity;
import com.fiap.restaurante.external.persistance.entites.Reserva;
import com.fiap.restaurante.interfaces.ReservaCreateDto;

import java.util.List;
import java.util.UUID;

public interface ReservaUseCases {

  Reserva create(ReservaCreateDto dto);
  List<ReservaEntity> findAll(UUID id);
}
