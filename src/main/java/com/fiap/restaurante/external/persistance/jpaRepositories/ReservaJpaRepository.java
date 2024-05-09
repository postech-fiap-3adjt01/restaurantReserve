package com.fiap.restaurante.external.persistance.jpaRepositories;


import com.fiap.restaurante.external.persistance.entites.Reserva;
import com.fiap.restaurante.external.persistance.entites.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReservaJpaRepository extends JpaRepository<Reserva, UUID> { }

