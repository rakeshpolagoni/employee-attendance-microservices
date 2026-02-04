package com.example.service1App.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    
    private static final String SECRET_KEY =
            "employee-attendance-secret-key-employee-attendance";

    
    private static final long EXPIRATION_TIME = 60 * 60 * 1000;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    
    public String generateToken(Long employeeId, String name) {

        return Jwts.builder()
                .setSubject(name)                 
                .claim("employeeId", employeeId)  
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + EXPIRATION_TIME)
                )
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    
    public boolean validateToken(String token) {
        try {
            extractAllClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
    public Long extractEmployeeId(String token) {
        return extractAllClaims(token).get("employeeId", Long.class);
    }

    
    public String extractEmployeeName(String token) {
        return extractAllClaims(token).getSubject();
    }

    
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
