package com.fiap.restaurante.service;

import com.fiap.restaurante.interfaces.RestauranteCreateDto;
import com.fiap.restaurante.external.persistance.entites.Restaurante;
import com.fiap.restaurante.external.persistance.jpaRepositories.RestauranteJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteJpaRepository restauranteRepository;

    public Restaurante create(RestauranteCreateDto dto) {
        Restaurante restauranteToCreate = Restaurante
                .builder()
                .nome(dto.nome())
                .capacidade(dto.capacidade())
                .cozinha(dto.cozinha())
                .build();
      return restauranteRepository.save(restauranteToCreate);
    }

    public List<Restaurante> findAll() {
        return restauranteRepository.findAll();
    }
}
