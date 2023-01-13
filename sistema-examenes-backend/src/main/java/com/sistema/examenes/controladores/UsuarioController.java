package com.sistema.examenes.controladores;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.examenes.entidades.Rol;
import com.sistema.examenes.entidades.Usuario;
import com.sistema.examenes.entidades.UsuarioRol;
import com.sistema.examenes.servicios.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@PostMapping("/")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception {
		usuario.setPerfil("default.png");
		
		usuario.setPassword(this.bcryptPasswordEncoder.encode(usuario.getPassword()));
		
		Set<UsuarioRol> usuarioRoles = new HashSet();
		
		Rol rol = new Rol();
		rol.setRolId(2L);
		rol.setNombre("NORMAL");
		
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setUsuario(usuario);
		usuarioRol.setRol(rol);
		
		usuarioRoles.add(usuarioRol);
		return usuarioService.guardarUsuario(usuario, usuarioRoles);
	}
	
	
	@GetMapping("/{username}")
	public Usuario obtenerUsuario(@PathVariable("username") String username) {
		return usuarioService.obtenerUsuario(username);
	}
	
	
	@DeleteMapping("/{id}")
	public void elminarUsuario(@PathVariable("id") Long id) {
		usuarioService.eliminarUsuario(id);
	}
	
}
