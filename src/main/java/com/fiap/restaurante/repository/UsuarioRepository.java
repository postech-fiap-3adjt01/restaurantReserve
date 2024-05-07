package com.fiap.restaurante.repository;

import com.fiap.restaurante.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
