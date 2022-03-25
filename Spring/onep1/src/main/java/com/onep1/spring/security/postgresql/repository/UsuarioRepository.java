package com.onep1.spring.security.postgresql.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onep1.spring.security.postgresql.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,String> {
    Optional<Usuario> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
