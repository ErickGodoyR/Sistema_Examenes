package com.sistema.examenes.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;


@Entity
@Table(name="Roles")
public class Rol {

	@Id
	private Long rolId;
	
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "rol")
	private Set<UsuarioRol> usaurioRoles = new HashSet<>();

	
	public Rol() {
		super();
	}


	public Rol(Long rolId, String nombre, Set<UsuarioRol> usaurioRoles) {
		super();
		this.rolId = rolId;
		this.nombre = nombre;
		this.usaurioRoles = usaurioRoles;
	}


	public Long getRolId() {
		return rolId;
	}


	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Set<UsuarioRol> getUsaurioRoles() {
		return usaurioRoles;
	}


	public void setUsaurioRoles(Set<UsuarioRol> usaurioRoles) {
		this.usaurioRoles = usaurioRoles;
	}
	
	
	
	
}
