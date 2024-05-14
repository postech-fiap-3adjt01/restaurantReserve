package com.fiap.restaurante.controllers.exceptions;

/**
 * Classe de ControllerNotFoundException.
 **/
public class ControllerNotFoundException extends RuntimeException {
  public ControllerNotFoundException(String message) {
    super(message);
  }
}
