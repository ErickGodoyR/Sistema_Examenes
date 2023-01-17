package com.sistema.examenes.entidades;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoriaId;
	
	private String titulo;
	
	private String descripcion;
	
	@OneToMany(mappedBy = "categoria",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Examen> examenes = new LinkedHashSet<>();

	
	public Categoria() {
		super();
	}	
	
	public Categoria(Long categoriaId, String titulo, String descripcion, Set<Examen> examenes) {
		super();
		this.categoriaId = categoriaId;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.examenes = examenes;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Examen> getExamenes() {
		return examenes;
	}

	public void setExamenes(Set<Examen> examenes) {
		this.examenes = examenes;
	}

	
	
}
