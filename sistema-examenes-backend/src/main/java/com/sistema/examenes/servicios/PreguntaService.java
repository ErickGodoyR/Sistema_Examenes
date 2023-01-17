package com.sistema.examenes.servicios;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.sistema.examenes.entidades.Examen;
import com.sistema.examenes.entidades.Pregunta;


@Service
public interface PreguntaService {

	Pregunta agregarPregunta (Pregunta pregunta);
	
	Pregunta actualizarPregunta (Pregunta pregunta);
	
	Set<Pregunta> obtenerPreguntas();
	
	Pregunta obtenerPregunta (Long preguntaId);
	
	Set<Pregunta> obtenerPreguntasDelExamen(Examen examen);
	
	void eliminarPregunta (Long preguntaId);


}
