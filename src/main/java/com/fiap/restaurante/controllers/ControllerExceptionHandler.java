package com.fiap.restaurante.controllers;


import com.fiap.restaurante.controllers.exceptions.BadRequestException;
import com.fiap.restaurante.controllers.exceptions.ControllerNotFoundException;
import com.fiap.restaurante.controllers.exceptions.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Controla os erros da aplicação.
 **/
@ControllerAdvice
public class ControllerExceptionHandler {

  /**
   * Controla os casos de entity not found.
   **/
  @ExceptionHandler(ControllerNotFoundException.class)
  public ResponseEntity<StandardError> entityNotFound(
          ControllerNotFoundException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError err = StandardError.builder()
            .timestamp(Instant.now())
            .status(status.value())
            .error("Entity not found")
            .message(e.getMessage())
            .path(request.getRequestURI())
            .build();
    return ResponseEntity.status(status).body(err);
  }

  /**
   * Controla os casos de bad request.
   **/
  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<StandardError> badRequest(
          BadRequestException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    System.out.println("Aqui");
    StandardError err = StandardError.builder()
            .timestamp(Instant.now())
            .status(status.value())
            .error("bad request")
            .message(e.getMessage())
            .path(request.getRequestURI())
            .build();
    return ResponseEntity.status(status).body(err);
  }
}
