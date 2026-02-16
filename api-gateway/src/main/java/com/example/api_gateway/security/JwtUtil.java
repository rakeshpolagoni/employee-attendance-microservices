package com.example.api_gateway.security;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;

@Component
public class JwtUtil {
	private final static String secret="mysecretkeymysecretkey,ysecretkey12345";
	
	private final SecretKey key =Keys.hmacShaKeyFor(secret.getBytes());
	
	
	public String generateToken(String email) {
		return Jwts.builder()
				.setSubject(email)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis()
                        + 1000 * 60 * 60))
				.signWith(key)
				.compact();
	}
	

}
