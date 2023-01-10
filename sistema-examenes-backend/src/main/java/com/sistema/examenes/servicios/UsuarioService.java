package com.sistema.examenes.servicios;

import com.sistema.examenes.entidades.Usuario;
import com.sistema.examenes.entidades.UsuarioRol;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {
	
	public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

	public Usuario obtenerUsuario(String username);
	public void eliminarUsuario(Long id);
}
