package com.fiap.restaurante.external.persistance.jparepositories;


import com.fiap.restaurante.external.persistance.entites.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestauranteJpaRepository extends JpaRepository<Restaurante, UUID> {
}

