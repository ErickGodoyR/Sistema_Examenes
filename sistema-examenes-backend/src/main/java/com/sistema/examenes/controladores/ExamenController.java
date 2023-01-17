package com.sistema.examenes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.examenes.entidades.Examen;
import com.sistema.examenes.servicios.ExamenService;

@RestController
@RequestMapping("/examen")
@CrossOrigin("*")
public class ExamenController {

	@Autowired
	private ExamenService examenService;
	
	
	@PostMapping("/")
	public ResponseEntity<Examen> guardarExamen(@RequestBody Examen examen){
		Examen examenGuardado = examenService.agregarExamen(examen);
		return ResponseEntity.ok(examenGuardado);
	}

	
	@GetMapping("/{examenId}")
	public Examen listarExamenPorId(@PathVariable("examenId") Long examenId) {
		return examenService.obtenerExamen(examenId);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<?> listarExamen(){
		return ResponseEntity.ok(examenService.obtenerExamenes());	
	}
	
	
	@PutMapping("/")
	public ResponseEntity<Examen> actualizarExamen(@RequestBody Examen examen) {
		return ResponseEntity.ok(examenService.actualizarExamen(examen));
	}
	
	
	@DeleteMapping("/{examenId}")
	public void eliminarExamen(@PathVariable("examenId")Long examenId) {
		examenService.eliminarExamen(examenId);
	}

}
