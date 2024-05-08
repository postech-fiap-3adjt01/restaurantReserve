package com.fiap.restaurante.external.persistance.repositories;


import com.fiap.restaurante.external.persistance.entites.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

    @Repository
    public interface RestauranteRepository extends JpaRepository<Restaurante, UUID> { }

