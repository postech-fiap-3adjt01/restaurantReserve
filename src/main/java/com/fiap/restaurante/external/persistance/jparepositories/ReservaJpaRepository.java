package com.fiap.restaurante.external.persistance.jparepositories;


import com.fiap.restaurante.external.persistance.entites.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReservaJpaRepository extends JpaRepository<Reserva, UUID> {
    List<Reserva> findByRestauranteId(UUID restauranteId);
}

