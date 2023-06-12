package com.sistema.examenes.controladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
import com.sistema.examenes.entidades.Pregunta;
import com.sistema.examenes.servicios.ExamenService;
import com.sistema.examenes.servicios.PreguntaService;

@RestController
@RequestMapping("/pregunta")
@CrossOrigin("*")
public class PreguntaController {

	@Autowired
	private PreguntaService preguntaService;

	@Autowired
	private ExamenService examenService;

	@PostMapping("/")
	public ResponseEntity<Pregunta> guardarPregunta(@RequestBody Pregunta pregunta) {
		return ResponseEntity.ok(preguntaService.agregarPregunta(pregunta));
	}

	@PutMapping("/")
	public ResponseEntity<Pregunta> actualizarPregunta(@RequestBody Pregunta pregunta) {
		return ResponseEntity.ok(preguntaService.actualizarPregunta(pregunta));
	}

	@GetMapping("/examen/{examenId}")
	public ResponseEntity<?> listarPreguntasDelExamen(@PathVariable("examenId") Long examenId) {
		Examen examen = examenService.obtenerExamen(examenId);
		Set<Pregunta> preguntas = examen.getPreguntas();

		List examenes = new ArrayList<>(preguntas);
		if (examenes.size() > Integer.parseInt(examen.getNumeroDePreguntas())) {
			examenes = examenes.subList(0, Integer.parseInt(examen.getNumeroDePreguntas() + 1));
		}

		Collections.shuffle(examenes);
		return ResponseEntity.ok(examenes);
	}

	@GetMapping("/{preguntaId}")
	public Pregunta listaPreguntaPorId(@PathVariable("preguntaId") Long preguntaId) {
		return preguntaService.obtenerPregunta(preguntaId);
	}

	@DeleteMapping("/{preguntaId}")
	public void eliminarPregunta(@PathVariable("preguntaId") Long preguntaId) {
		preguntaService.eliminarPregunta(preguntaId);
	}

	@GetMapping("/examen/todos/{examenId}")
	public ResponseEntity<?> listarPreguntasComoAdmin(@PathVariable("examenId") Long examenId) {
		Examen examen = new Examen();
		examen.setExamenId(examenId);
		Set<Pregunta> preguntas = preguntaService.obtenerPreguntasDelExamen(examen);
		return ResponseEntity.ok(preguntas);
	}
}
