package com.alkemy.preaceleracion.auth.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {
	
	@Value("${app.jwt-secret}")
	private String jwtSecret;
	
	private Date fechaActual = new Date();
	
	private Date fechaExpiracion = new Date(fechaActual.getTime() + (1000 * 60 * 60 * 10));
	
	//Extrae el nombre de usuario del token
	public String extractUsername(String token){
		return extractClaim(token, Claims::getSubject);
	}
	
	//Extrae la fecha de expiración del token
	public Date extractExpiration(String token){
		return extractClaim(token, Claims::getExpiration);
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	//Extrae los claims del token
	private Claims extractAllClaims(String token){
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	}
	
	//Verifica sí el token está expirado
	private Boolean isTokenExpired(String token){
		return extractExpiration(token).before(new Date());
	}
	
	//Genera el token con los claims y el nombre de usuario
	public String generateToken(UserDetails userDetails){
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails.getUsername());
	}
	
	/*Crea el token seteandole los claims, seteandole el nombre de usuario
	la fecha actual incluyendo horas, minutos y segundos a través del
	método setIssuedAt() y la fecha de expiración utilizando*/
	public String createToken(Map<String, Object> claims, String subjectUsername){
		return Jwts.builder().setClaims(claims)
		.setSubject(subjectUsername).setIssuedAt(fechaActual)
		.setExpiration(fechaExpiracion).signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
	}
	
	public Boolean validateToken(String token, UserDetails userDetails){
		final String username = extractUsername(token);
		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}
}