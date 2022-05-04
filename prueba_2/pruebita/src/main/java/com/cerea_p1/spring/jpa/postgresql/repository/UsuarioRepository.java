package com.cerea_p1.spring.jpa.postgresql.repository;

import java.util.Optional;
import com.cerea_p1.spring.jpa.postgresql.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,String> {
    Optional<Usuario> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    // @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
    // List<User> findUserByUserStatusAndUserName(@Param("status") Integer userStatus, 
    // @Param("name") String userName);
}
