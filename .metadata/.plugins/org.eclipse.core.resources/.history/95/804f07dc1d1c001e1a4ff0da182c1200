package PolyHealthCenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PolyHealthCenter.model.Terapia;
import PolyHealthCenter.service.TerapiaService;


@RestController
@RequestMapping("/api/terapie")
public class TerapiaController {

	@Autowired private TerapiaService service;

	@GetMapping
	//ResponseEntity  oggetto che contiene il dato e lo status code
	public ResponseEntity<List<Terapia>> getAllTerapie() {
		//return userService.getAll(); -> solo il body della risposta
		//return new ResponseEntity(userService.getAll(), HttpStatus.OK); -> il body e lo status code della risposta 
		return ResponseEntity.ok(service.getAll()); // Metodo alternativo -> il body e lo status code della risposta
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getTerapiaById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}


	@PostMapping
	public ResponseEntity<?> createTerapia(@RequestBody Terapia terapia) {
		return ResponseEntity.ok(service.createTerapia(terapia));

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTerapia(@RequestBody Terapia terapia, @PathVariable Long id) {
		return ResponseEntity.ok(service.updateTerapia(terapia, id));

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTerapia(@PathVariable Long id) {
		return ResponseEntity.ok(service.removeTerapia(id));

	}
	


}
