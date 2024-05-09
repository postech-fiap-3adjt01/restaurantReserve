package com.fiap.restaurante.external.persistance.jpaRepositories;

import com.fiap.restaurante.external.persistance.entites.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<Usuario, UUID> {
}
