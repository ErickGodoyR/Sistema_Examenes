package com.sistema.examenes.servicios;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.examenes.entidades.Examen;
import com.sistema.examenes.repositorio.ExamenRepository;

@Service
public class ExamenServiceImpl implements ExamenService{

	@Autowired
	public ExamenRepository examenRepository;
	
	@Override
	public Examen agregarExamen(Examen examen) {
		return examenRepository.save(examen);
	}

	@Override
	public Examen actualizarExamen(Examen examen) {
		return examenRepository.save(examen);
	}

	@Override
	public Set<Examen> obtenerExamenes() {
		return new LinkedHashSet<>(examenRepository.findAll());
	}

	@Override
	public Examen obtenerExamen(Long examenId) {
		return examenRepository.findById(examenId).get();
	}

	@Override
	public void eliminarExamen(Long examenId) {
		Examen examen = new Examen();
		examen.setExamenId(examenId);
		examenRepository.delete(examen);
	}

}
