package com.fiap.restaurante.controllers;


import com.fiap.restaurante.entities.RestauranteEntity;
import com.fiap.restaurante.external.persistance.entites.Restaurante;
import com.fiap.restaurante.interfaces.RestauranteCreateDto;
import com.fiap.restaurante.service.RestauranteService;
import com.fiap.restaurante.usecases.RestauranteUseCasesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
   * Procura por todos os restaurantes.
   **/
  @GetMapping
  public ResponseEntity<Object> findAll(@RequestParam String query) {
    return new ResponseEntity<>(restauranteUseCases.findAll(query), HttpStatus.OK);
  }

  /**
   * Cria um novo restaurante.
   **/
  @PostMapping(
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> create(@RequestBody RestauranteCreateDto dto) {
    try {
      return ResponseEntity.status(HttpStatus.CREATED).body(restauranteUseCases.create(dto));
    } catch (Exception error) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.getMessage());
    }
  }

}
