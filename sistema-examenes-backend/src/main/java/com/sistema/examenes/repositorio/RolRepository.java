package com.sistema.examenes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.examenes.entidades.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

}
