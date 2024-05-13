package com.fiap.restaurante.external.persistance.jparepositories;


import com.fiap.restaurante.external.persistance.entites.Comentario;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComentarioJpaRepository extends JpaRepository<Comentario, UUID> {
}

