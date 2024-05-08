package com.fiap.restaurante.controllers;


import com.fiap.restaurante.interfaces.RestauranteCreateDto;
import com.fiap.restaurante.external.persistance.entites.Restaurante;
import com.fiap.restaurante.service.RestauranteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping("/restaurante")
    public List<Restaurante> findAll() {
        return restauranteService.findAll();
    }

    @PostMapping("/restaurante")
    public Restaurante create(@RequestBody @Valid RestauranteCreateDto dto) {
        return restauranteService.create(dto);
    }

}
