package com.sistema.examenes;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sistema.examenes.entidades.Rol;
import com.sistema.examenes.entidades.Usuario;
import com.sistema.examenes.entidades.UsuarioRol;
import com.sistema.examenes.excepciones.UsuarioFoundException;
import com.sistema.examenes.servicios.UsuarioService;

@SpringBootApplication
public class SistemaExamenesBackendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		try {
		
			Usuario usuario = new Usuario();
			
			usuario.setNombre("Erick");
			usuario.setApellido("Godoy");
			usuario.setUsername("erick");
			usuario.setPassword(bCryptPasswordEncoder.encode("12345"));
			usuario.setEmail("erick@gmail.com");
			usuario.setTelefono("987875643");
			usuario.setPerfil("foto.png");
			
			
			Rol rol = new Rol();
			
			rol.setRolId(1L);
			rol.setNombre("ADMIN");
			
			Set<UsuarioRol> usuarioRoles = new HashSet();
			UsuarioRol usuarioRol = new UsuarioRol();
			
			usuarioRol.setRol(rol);
			usuarioRol.setUsuario(usuario);
			usuarioRoles.add(usuarioRol);
			
			Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario,usuarioRoles);
			System.out.println(usuarioGuardado.getUsername());	

			
		}catch(UsuarioFoundException exception) {
			exception.printStackTrace();
		}
		*/
	}

}
