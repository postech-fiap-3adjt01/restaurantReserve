package com.fiap.restaurante.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.restaurante.controllers.exceptions.BadRequestException;
import com.fiap.restaurante.controllers.exceptions.ValidationTrigger;
import com.fiap.restaurante.interfaces.ReservaCreateDto;
import com.fiap.restaurante.usecases.ReservaUseCasesImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * Controller de Reserva.
 **/
@RestController
@RequestMapping("reserva")
@RequiredArgsConstructor
public class ReservaController {

  private final ReservaUseCasesImpl reservaUseCases;

  /**
   * Procura por todos as reservas.
   **/
  @GetMapping("/{id}")
  public ResponseEntity<Object> findAll(@PathVariable UUID id) {
    return new ResponseEntity<>(reservaUseCases.findAll(id), HttpStatus.OK);
  }

  /**
   * Cria um novo restaurante.
   **/
  @PostMapping(
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> create(
          @RequestBody @Valid ReservaCreateDto dto,
          BindingResult bindingResult) throws BadRequestException {
    new ValidationTrigger(bindingResult).verify();
    try {
      return ResponseEntity.status(HttpStatus.CREATED).body(reservaUseCases.create(dto));
    } catch (Exception error) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.getMessage());
    }
  }

}