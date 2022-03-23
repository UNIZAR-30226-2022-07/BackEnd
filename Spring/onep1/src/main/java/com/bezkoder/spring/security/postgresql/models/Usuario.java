package com.bezkoder.spring.security.postgresql.models;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Usuario", 
            uniqueConstraints = { 
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email") 
            })
public class Usuario {

        @Id
        @Size(max = 60)
        @Email
        private String email;
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
     //   private Long id;
    //    @NotBlank
    //    @Size(max = 20)
        @NotBlank
        @Size(max = 50)
        private String username;
        @NotBlank
        @Size(max = 30)
        private String password;
//        @ManyToMany(fetch = FetchType.LAZY)
 //       @JoinTable(	name = "user_roles", 
 //                   joinColumns = @JoinColumn(name = "user_id"), 
 //                   inverseJoinColumns = @JoinColumn(name = "role_id"))
    //    private Set<Role> roles = new HashSet<>();
        @NotBlank
        @Size(max = 70)
        private String pais;
        @NotBlank
        private int puntos;
        @NotBlank
        private int ultimaPartida;
        public Usuario() {
        }
        public Usuario(String username, String email, String password, String pais) {
            this.username = username;
            this.email = email;
            this.password = password;
            this.pais = pais;
            this.puntos = 0;
            this.ultimaPartida = 0;
        }

        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getPais() {
            return pais;
        }
        public void setPais(String pais) {
            this.pais = pais;
        }
        public int getPuntos() {
            return puntos;
        }
        public void setPuntos(int puntos) {
            this.puntos = puntos;
        }
        public int getUltimaPartida() {
            return puntos;
        }
        public void setUltimaPartida(int ultimaPartida) {
            this.ultimaPartida = ultimaPartida;
        }
}