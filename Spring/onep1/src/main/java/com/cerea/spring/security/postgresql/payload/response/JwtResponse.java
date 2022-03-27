package com.cerea.spring.security.postgresql.payload.response;

import java.util.List;
import com.cerea.spring.security.postgresql.models.Amigo;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private String email;
    private List<Amigo> amigos;
    private String pais;
    private int puntos;


	public JwtResponse(String accessToken, String username, String email, List<Amigo> amiguis, String pais, int puntos) {
		this.token = accessToken;
		this.username = username;
		this.email = email;
		this.amigos = amiguis;
        this.pais = pais;
        this.puntos = puntos;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Amigo> getAmigos() {
		return this.amigos;
	}

    public void setPuntos(int puntos){
        this.puntos = puntos;
    }

    public int getPuntos(){
        return this.puntos;
    }

    public void setPais(String pais){
        this.pais = pais;
    }

    public String getPais(){
        return this.pais;
    }
}