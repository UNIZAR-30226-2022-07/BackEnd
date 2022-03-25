package com.cerea.spring.security.postgresql.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.*;

@Entity
@Table(name = "Usuario", 
            uniqueConstraints = { 
                @UniqueConstraint(columnNames = "nombre_de_usuario"),
                @UniqueConstraint(columnNames = "correo_electronico") 
            })
public class Usuario {

    @Id
    @Size(max = 60)
    @Pattern(regexp = ".+[@].+[\\.].+")
    private String email;

    @Size(max = 50)
    private String username;
    
    @NotNull
    @Size(max = 30)
    private String password;
    
    @NotNull
    @OneToMany(mappedBy = "usuario")
    private List<Amigo> amigos = new ArrayList<Amigo>();

    @NotNull
    @Size(max = 70)
    private String pais;

    @NotNull
    private int puntos;

    public Usuario(String username, String email, String password, String pais) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.pais = pais;
        this.puntos = 0;
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
}