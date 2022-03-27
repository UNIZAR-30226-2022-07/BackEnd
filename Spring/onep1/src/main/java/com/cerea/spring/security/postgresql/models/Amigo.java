package com.cerea.spring.security.postgresql.models;

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
    @ManyToOne()
    @Column(name="usuario1")
    @JoinColumn(name = "Usuario")
    private Usuario usuario;

    @Size(max = 50)
    @Pattern(regexp = ".+[@].+[\\.].+")
    @ManyToOne()
    @Column(name="usuario2")
    @JoinColumn(name = "Usuario2")
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