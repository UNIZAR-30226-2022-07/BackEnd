package com.cerea.spring.security.postgresql.repository;

import java.util.Optional;

import com.cerea.spring.security.postgresql.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,String> {
    Usuario findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
