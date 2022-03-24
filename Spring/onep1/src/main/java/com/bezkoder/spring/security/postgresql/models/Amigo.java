package com.bezkoder.spring.security.postgresql.models;

import javax.persistence.*;

import javax.validation.constraints.*;

@Entity
@Table(name = "Amigo", 
            uniqueConstraints = { 
                @UniqueConstraint(columnNames = {"Usuario", "Usuario2"})
            })
public class Amigo {
    @Id
    @Size(max = 50)
    @Pattern(regexp = ".+[@].+[\\.].+")
	private Usuario usuario;
    @Id
    @Size(max = 50)
    @Pattern(regexp = ".+[@].+[\\.].+")
	private Usuario usuario2;
	
	public Amigo() {
	}
	public Amigo(Usuario u, Usuario u2) {
		this.usuario = u;
        this.usuario2 = u2;
	}

    public Usuario getUsuario(){
        return this.usuario;
    }

    public void setUsuario(Usuario u){
        this.usuario = u;
    }

    public Usuario getAmigo(){
        return this.usuario2;
    }

    public void setAmigo(Usuario u){
        this.usuario2 = u;
    }
	
}
