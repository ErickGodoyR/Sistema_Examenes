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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "examenes")
public class Examen {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="examenId")
	 private Long examenId;

	 private String titulo;
	 
	 @Column(name="descripcion", columnDefinition = "varchar(255)")
	 private String descripcion;
	 
	 @Column(name="puntosMaximos", columnDefinition = "varchar(255)")
	 private String puntosMaximos;
	 
	 @Column(name="numeroDePreguntas", columnDefinition = "varchar(255)")
	 private String numeroDePreguntas;
	 
	 private boolean activo = false;

	 @ManyToOne(fetch = FetchType.EAGER)
	 private Categoria categoria;

	 @OneToMany(mappedBy = "examen",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	 @JsonIgnore
	 private Set<Pregunta> preguntas = new HashSet<>();

	 
	 public Examen() {
		 super();
	 }
	 
	 public Examen(Long examenId, String titulo, String descripcion, String puntosMaximos, String numeroDePreguntas,
			boolean activo, Categoria categoria, Set<Pregunta> preguntas) {
		super();
		this.examenId = examenId;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.puntosMaximos = puntosMaximos;
		this.numeroDePreguntas = numeroDePreguntas;
		this.activo = activo;
		this.categoria = categoria;
		this.preguntas = preguntas;
	}

	public Long getExamenId() {
		return examenId;
	}

	public void setExamenId(Long examenId) {
		this.examenId = examenId;
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

	public String getPuntosMaximos() {
		return puntosMaximos;
	}

	public void setPuntosMaximos(String puntosMaximos) {
		this.puntosMaximos = puntosMaximos;
	}

	public String getNumeroDePreguntas() {
		return numeroDePreguntas;
	}

	public void setNumeroDePreguntas(String numeroDePreguntas) {
		this.numeroDePreguntas = numeroDePreguntas;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Set<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}


}
