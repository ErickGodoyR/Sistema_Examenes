<<<<<<< HEAD
package com.sistema.examenes.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sistema.examenes.entidades.Usuario;
import com.sistema.examenes.repositorio.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioRepository.findByUsername(username);
		if(usuario == null){
			throw new UsernameNotFoundException("Usuario no existe");
		}
		return usuario;
	}

}
=======
package com.sistema.examenes.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sistema.examenes.entidades.Usuario;
import com.sistema.examenes.repositorio.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioRepository.findByUsername(username);
		if(usuario == null){
			throw new UsernameNotFoundException("Usuario no existe");
		}
		return usuario;
	}

}
>>>>>>> bcf4f66556863e567b479d84164c3e110563edeb
