package com.fiap.restaurante.controller;


import com.fiap.restaurante.Dto.RestauranteCreateDto;
import com.fiap.restaurante.entity.Restaurante;
import com.fiap.restaurante.repository.RestauranteRepository;
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
