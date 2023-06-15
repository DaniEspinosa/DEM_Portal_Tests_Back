package com.sistema.examenes.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.entidades.Categoria;
import com.sistema.examenes.entidades.Examen;



public interface ExamenRepository extends JpaRepository<Examen, Long>{
	
	List<Examen> findByCategoria(Categoria categoria);
	
	List<Examen> findByActivo(boolean activo);
	
	List<Examen> findByCategoriaAndActivo(Categoria categoria, boolean activo);
}
