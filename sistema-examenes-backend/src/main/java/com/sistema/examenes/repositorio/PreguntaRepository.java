package com.sistema.examenes.repositorio;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.examenes.entidades.Examen;
import com.sistema.examenes.entidades.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta,Long> {

	Set<Pregunta> findByExamen(Examen examen);
}
