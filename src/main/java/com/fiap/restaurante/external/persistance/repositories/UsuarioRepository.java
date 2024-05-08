package com.fiap.restaurante.external.persistance.repositories;

import com.fiap.restaurante.external.persistance.entites.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
