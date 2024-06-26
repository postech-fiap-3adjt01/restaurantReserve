package com.fiap.restaurante.controllers;


import com.fiap.restaurante.controllers.exceptions.BadRequestException;
import com.fiap.restaurante.controllers.exceptions.ValidationTrigger;
import com.fiap.restaurante.interfaces.RestauranteCreateDto;
import com.fiap.restaurante.usecases.RestauranteUseCasesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Controller de Restaurante.
 **/
@RestController
@RequestMapping("restaurante")
@RequiredArgsConstructor
public class RestauranteController {

  private final RestauranteUseCasesImpl restauranteUseCases;

  /**
   * Procura por todos os restaurantes com query.
   **/
  @GetMapping
  public ResponseEntity<Object> findAll(@RequestParam(required = false) String query) {
    return new ResponseEntity<>(restauranteUseCases.findAll(query), HttpStatus.OK);
  }

  /**
   * Cria um novo restaurante.
   **/
  @PostMapping(
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> create(
          @RequestBody @Valid RestauranteCreateDto dto,
          BindingResult bindingResult) throws BadRequestException {
    new ValidationTrigger(bindingResult).verify();
    try {
      return ResponseEntity.status(HttpStatus.CREATED).body(restauranteUseCases.create(dto));
    } catch (Exception error) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.getMessage());
    }
  }

}
