package com.fiap.restaurante.repository;


import com.fiap.restaurante.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

    @Repository
    public interface RestauranteRepository extends JpaRepository<Restaurante, UUID> { }

