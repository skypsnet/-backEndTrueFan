package org.trueFanBoutique.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trueFanBoutique.dto.ChangeData;
import org.trueFanBoutique.model.Usuario;
import org.trueFanBoutique.service.UsuarioService;

@RestController
@RequestMapping(path="/truefan/usuarios/")
public class UsuarioController {

	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	

	@GetMapping
	public List<Usuario> getUsuarios(){
		return usuarioService.getAllUsuarios();
	}//getAllUsuario
	
	@GetMapping(path="{userId}")
	public Usuario getUsuario(@PathVariable("userId")Long id) {
		return usuarioService.getUsuario(id);
	}//getUsuario
	
	@DeleteMapping(path="{userId}")
	public Usuario deleteUsuario(@PathVariable("userId")Long id) {
		return usuarioService.deleteUsuario(id);
	}//deleteUsuario
	
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}//addUsuario
	
	
	@PutMapping(path="{userId}")
	public Usuario updateData(@PathVariable("userId") Long id, @RequestBody ChangeData changeData) {
		System.out.println(changeData);
	    return usuarioService.updateData(id, changeData);
	}//updateData


		
}//class UsuarioController 
