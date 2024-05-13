package com.fiap.restaurante.external.persistance.jparepositories;


import com.fiap.restaurante.external.persistance.entites.Horario;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de horario.
 **/
@Repository
public interface HorarioJpaRepository extends JpaRepository<Horario, UUID> {
}

