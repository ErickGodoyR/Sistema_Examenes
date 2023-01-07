package com.sistema.examenes.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usaurioRoles")
public class UsuarioRol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarioRolId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;
	
	@ManyToOne
	private Rol rol;
	
	
	public UsuarioRol() {
		super();
	}


	public UsuarioRol(Long usuarioRolId, Usuario usuario, Rol rol) {
		super();
		this.usuarioRolId = usuarioRolId;
		this.usuario = usuario;
		this.rol = rol;
	}


	public Long getUsuarioRolId() {
		return usuarioRolId;
	}


	public void setUsuarioRolId(Long usuarioRolId) {
		this.usuarioRolId = usuarioRolId;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
}
