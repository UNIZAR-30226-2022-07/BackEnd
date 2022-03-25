package com.cerea.spring.security.postgresql.security.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cerea.spring.security.postgresql.models.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            Usuario user = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
            return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        /* String token = Jwts.builder().setIssuedAt(new Date()).setIssuer("https://www.alexastudillo.com")
            .setSubject((((Usuario) authResult.getPrincipal()).getUsername()))
            .setExpiration(new Date(System.currentTimeMillis() + 864_000_000))
            .signWith(SignatureAlgorithm.HS512, "alex1234").compact(); */
        response.addHeader("Authorization", "Bearer " + "token");
        // mensaje que se va a devolver
    }
	
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {

        logger.debug("failed authentication while attempting to access " );

        //Add more descriptive message
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Authentication Failed");
        super.unsuccessfulAuthentication(request, response, failed);
    }
}