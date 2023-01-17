package com.sistema.examenes.servicios;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.sistema.examenes.entidades.Examen;

@Service
public interface ExamenService {

	Examen agregarExamen (Examen examen);
	
	Examen actualizarExamen (Examen examen);
	
	Set<Examen> obtenerExamenes();
	
	Examen obtenerExamen (Long examenId);
	
	void eliminarExamen (Long examenId);
}
