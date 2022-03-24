package com.bezkoder.spring.security.postgresql.models;

import javax.persistence.*;

import javax.validation.constraints.*;

@Entity
@Table(name = "Usuario", 
            uniqueConstraints = { 
                @UniqueConstraint(columnNames = "Nombre_de_usuario"),
                @UniqueConstraint(columnNames = "Correo_electronico") 
            })
public class Usuario {

        @Id
        @Size(max = 60)
        @Pattern(regexp = ".+[@].+[\\.].+")
        private String email;
        @NotNull
        @Size(max = 50)
        private String username;
        @NotNull
        @Size(max = 30)
        private String password;
//        @ManyToMany(fetch = FetchType.LAZY)
 //       @JoinTable(	name = "user_roles", 
 //                   joinColumns = @JoinColumn(name = "user_id"), 
 //                   inverseJoinColumns = @JoinColumn(name = "role_id"))
    //    private Set<Role> roles = new HashSet<>();
        @NotNull
        @Size(max = 70)
        private String pais;
        @NotNull
        private int puntos;
        @NotNull
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
            return this.ultimaPartida;
        }
        public void setUltimaPartida(int ultimaPartida) {
            this.ultimaPartida = ultimaPartida;
        }
}