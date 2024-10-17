package org.trueFanBoutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.trueFanBoutique.dto.ChangeData;
import org.trueFanBoutique.model.Usuario;
import org.trueFanBoutique.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private PasswordEncoder encoder;

	public final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}//constructor
	
	public List<Usuario> getAllUsuarios(){
		return usuarioRepository.findAll();
	}//getAllUsuarios (GET)
	
	public Usuario getUsuario(Long id) {
		return usuarioRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El usuario con el [" +id+"] no existe")
				);
	}//getUsuario (GET)
	
	public Usuario getUsuario(String email) {
		return usuarioRepository.findByEmail(email).orElseThrow(
				()->new IllegalArgumentException("El usuario con el [" +email+"] no existe")
				);
	}//getUsuario (GET)
	
	public Usuario addUsuario(Usuario usuario) {
		Optional<Usuario> user = usuarioRepository.findByEmail(usuario.getEmail());
		if(user.isEmpty()) {
			usuario.setPassword(encoder.encode(usuario.getPassword()));
			return usuarioRepository.save(usuario);
			}//if empty
		
		else{System.out.println("este correo ya esta en uso");
			return null;
			}//else
	}//addUsuario (POST)
	
	public Usuario deleteUsuario(Long id) {
		Usuario user = null;
		if (usuarioRepository.existsById(id)) {
				user=usuarioRepository.findById(id).get();
				usuarioRepository.deleteById(id);
			}//if
		return user;
	}//deleteUsuario (DEL)
	
	public Usuario updateData(Long id, ChangeData changeData) {
	    Usuario user = null;
	    
	    if (usuarioRepository.existsById(id)) {
			Usuario usuario = usuarioRepository.findById(id).get();

			// Actualizar contrase�a si es necesario
			if(changeData.getNpassword()!= null || changeData.getPassword()!= null ) {
				if(encoder.matches(changeData.getPassword(),usuario.getPassword())){
					usuario.setPassword(encoder.encode(changeData.getNpassword()));
					usuarioRepository.save(usuario);
					user = usuario;
				}//if getPassword.matches(changePassword)
			}			
			
            // Actualizar telfono si es necesario
			if (changeData.getNphone()!=null && 
	                usuario.getPhone().equals(changeData.getPhone())){
				
	                usuario.setPhone(changeData.getNphone());
	    			usuarioRepository.save(usuario);
	    			user = usuario;
	            }//if
			
		}//if exists
	    return user;
	}//updateData
	
	public boolean validateUser(Usuario usuario) {
		Optional<Usuario> user = usuarioRepository.findByEmail(usuario.getEmail());
		
		if(user.isPresent()){
			Usuario tmpUser = user.get();
			if(encoder.matches(usuario.getPassword(), tmpUser.getPassword())){
				return true;
			}//if matches
		}//if ispresent
		return false;
	}//validateUser

}//class UsuarioService 
