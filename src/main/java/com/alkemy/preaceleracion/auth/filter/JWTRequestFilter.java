package com.alkemy.preaceleracion.auth.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.alkemy.preaceleracion.auth.service.JwtUtil;
import com.alkemy.preaceleracion.auth.service.UserDetailsCustomService;
import com.sun.net.httpserver.Filter.Chain;

@Component
public class JWTRequestFilter extends OncePerRequestFilter{
	
	@Autowired
	private UserDetailsCustomService userDetailsCustomService;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	throws ServletException, IOException {
		
		final String authorizationHeader = request.getHeader("Authorization");
		
		String username = null;
		String jwtToken = null;
		
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
			jwtToken = authorizationHeader.substring(7);
			username = jwtUtil.extractUsername(jwtToken);
		}
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
			UserDetails userDetails = this.userDetailsCustomService.loadUserByUsername(username);
			
			if(jwtUtil.validateToken(jwtToken, userDetails)){
				UsernamePasswordAuthenticationToken authReq =
				new UsernamePasswordAuthenticationToken(userDetails.getUsername(),
				userDetails.getPassword());
				Authentication auth = authenticationManager.authenticate(authReq);
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}
	filterChain.doFilter(request, response);
	}

}