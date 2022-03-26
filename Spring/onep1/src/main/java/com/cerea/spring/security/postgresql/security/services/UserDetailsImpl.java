package com.cerea.spring.security.postgresql.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.cerea.spring.security.postgresql.models.Usuario;
import com.cerea.spring.security.postgresql.models.Amigo;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	private String username;
	private String email;
    private String pais;
    private int puntos;
	private List<Amigo> amigos;
	
    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String username, String email, String password, String pais, int puntos, List<Amigo> amiguis, Collection<? extends GrantedAuthority> authorities) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.pais = pais;
        this.puntos = puntos;
		this.amigos = amiguis;
        this.authorities = authorities;

    }
    /* public static UserDetailsImpl build(Usuario user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());
    } */

    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public String getEmail() {
		return email;
	}

    public String getPais() {
		return pais;
	}

    public int getPuntos() {
		return puntos;
	}
    
	public List<Amigo> getAmigos() {
		return amigos;
	}

	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(email, user.email);
	}

}
