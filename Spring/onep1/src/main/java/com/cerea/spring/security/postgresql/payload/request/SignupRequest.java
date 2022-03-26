package com.cerea.spring.security.postgresql.payload.request;

import javax.validation.constraints.*;
 
public class SignupRequest {
    @NotNull
    @Size(min = 3, max = 50)
    private String username;
 
    @NotNull
    @Size(max = 60)
 //   @Email
    @Pattern(regexp = ".+[@].+[\\.].+")
    private String email;
    
    @NotNull
    @Size(min = 6, max = 30)
    private String password;

    @NotNull
    @Size(min = 3, max = 70)
    private String pais;
  
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
}
