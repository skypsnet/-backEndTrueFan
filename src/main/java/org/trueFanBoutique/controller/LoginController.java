package org.trueFanBoutique.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.trueFanBoutique.config.JwtFilter;
import org.trueFanBoutique.dto.Token;
import org.trueFanBoutique.model.Usuario;
import org.trueFanBoutique.service.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/truefan/login/")
@CrossOrigin(origins="http://127.0.0.1:5502")
public class LoginController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}//constructor

	@PostMapping
	public Token loginUser(@RequestBody Usuario usuario) throws ServletException {
		if(usuarioService.validateUser(usuario)) {
			System.out.println("Usuario valido" + " "+usuario.getEmail()+" "+usuario.getId());
			Long userId = usuarioService.getUsuario(usuario.getEmail()).getId();
			return new Token(generateToken(usuario.getEmail()), userId);
		}//validateUser
		throw new ServletException("Nombre de usuario o contraseña incorrectos[" + usuario.getEmail() + "]");
	}//loginUser
	
	private String generateToken(String email) {
		Calendar calendar = Calendar.getInstance();///Fecha y hora de hoy
		calendar.add(Calendar.HOUR,12); //Prueba desarrollo
		//calendar.add(Calendar.MINUTE, 30); //PRODUCC
		
		return Jwts.builder().setSubject(email)
				.claim("role", "user")
				.setIssuedAt(new Date())
				.setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
				.compact();	
	}//generateToken
	
}//class LoginController 
