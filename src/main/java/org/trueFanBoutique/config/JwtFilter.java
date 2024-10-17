package org.trueFanBoutique.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean{
	
	public static String secret = "xtentacion";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String authHeader =  httpServletRequest.getHeader("Authorization");
		
		if (  (("POST".equals(httpServletRequest.getMethod())) && 
				(! httpServletRequest.getRequestURI().contains("/truefan/usuarios/") )  )  
				||
				( ("GET".equals(httpServletRequest.getMethod())) && 
						(! httpServletRequest.getRequestURI().contains("/truefan/productos/") )  ) ||
			  ("PUT".equals(httpServletRequest.getMethod())) ||
			  ("DELETE".equals(httpServletRequest.getMethod()))
			) {
			
			if (authHeader == null || ! authHeader.startsWith("Bearer: ")) {
				System.out.println("1. Invalid Token");
				throw new ServletException("1. Invalid Token");
			}//if autHEader
			
			String token = authHeader.substring(7);
			try {
				Claims claims = Jwts.parser().setSigningKey(secret)
						.parseClaimsJws(token).getBody();
				claims.forEach((key,value) -> System.out.println("key: "+ key + " value: "+value));
			} catch (SignatureException | MalformedJwtException | ExpiredJwtException e) {
				System.out.println("2. Invalid Token");
				throw new ServletException("2. Invalid Token");
			}//if getMethod
			
		}//if gethMetod
		chain.doFilter(request, response); //siempre ultima linea de cualquier doFilter
	}//dofilter
	
}//class JwtFilter 
