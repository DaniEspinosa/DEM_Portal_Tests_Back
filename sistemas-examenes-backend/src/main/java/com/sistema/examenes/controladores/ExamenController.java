package com.sistema.examenes.controladores;

import java.util.List;

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

import com.sistema.examenes.entidades.Categoria;
import com.sistema.examenes.entidades.Examen;
import com.sistema.examenes.servicios.ExamenService;

@RestController
@RequestMapping("/examen")
@CrossOrigin("*")
public class ExamenController {

	@Autowired
	private ExamenService examenService;

	@GetMapping("/")
	public ResponseEntity<?> listarExamenes() {
		return ResponseEntity.ok(examenService.obtenerExamen());
	}

	@GetMapping("/{examenId}")
	public Examen listarExamen(@PathVariable("examenId") Long examenId) {
		return examenService.obtenerExamen(examenId);
	}

	@PostMapping("/")
	public ResponseEntity<Examen> guardarExamen(@RequestBody Examen examen) {
		return ResponseEntity.ok(examenService.agregarExamen(examen));
	}

	@PutMapping("/")
	public ResponseEntity<Examen> actualizarExamen(@RequestBody Examen examen) {
		return ResponseEntity.ok(examenService.agregarExamen(examen));
	}

	@DeleteMapping("/{examenId}")
	public void eliminarExamen(@PathVariable("examenId") Long examenId) {
		examenService.eliminarExamen(examenId);
	}

	@GetMapping("/categoria/{categoriaId}")
	public List<Examen> listarExamenesDeUnaCategoria(@PathVariable("categoriaId") Long categoriaId) {
		Categoria categoria = new Categoria();
		categoria.setCategoriaId(categoriaId);
		return examenService.listarExamenesDeUnaCategoria(categoria);
	}
	
	@GetMapping("/activo")
	public List<Examen> listarExamenesActivos() {
		return examenService.obtenerExamenesActivos();
	}
	
	@GetMapping("/categoria/activo/{categoriaId}")
	public List<Examen> ListasExamenesActivosDeUnaCategoria(@PathVariable("categoriaId") Long categoriaId) {
		Categoria categoria = new Categoria();
		categoria.setCategoriaId(categoriaId);
		return examenService.obtenerExamenesActivosDeUnaCategoria(categoria);
	}
}
