package com.sistema.examenes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.examenes.entidades.Examen;

@Repository
public interface ExamenRepository extends JpaRepository<Examen,Long> {

}
