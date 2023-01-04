package com.sistema.examenes.entidades;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.OneToMany;

@Entity
@Table(name="Usuarios",uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username")
	@NotBlank
	private String username;
	
	@Column(name = "password")
	@NotBlank
	private String password;
	
	@Column(name = "nombre")
	@NotBlank
	private String nombre;
	
	@Column(name = "apellido")
	@NotBlank
	private String apellido;
	
	@Column(name = "email")
	@NotBlank
	private String email;
	
	@Column(name = "telefono")
	@NotBlank
	private String telefono;
	private boolean enabled = true;
	private String perfil;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="usuario")
	@JsonIgnore
	private Set<UsuarioRol> usuarioRoles = new HashSet<>();


	public Usuario() {
		super();
	}


	public Usuario(Long id, String username, String password, String nombre, String apellido, String email,
			String telefono, boolean enabled, String perfil, Set<UsuarioRol> usuarioRoles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.enabled = enabled;
		this.perfil = perfil;
		this.usuarioRoles = usuarioRoles;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getPerfil() {
		return perfil;
	}


	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}


	public Set<UsuarioRol> getUsuarioRoles() {
		return usuarioRoles;
	}


	public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}

	
	
	
}
