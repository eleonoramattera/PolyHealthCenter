package PolyHealthCenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PolyHealthCenter.model.Utente;
import PolyHealthCenter.service.UtenteService;


@RestController
@RequestMapping("/api/utenti")
public class UtenteController {
	@Autowired private UtenteService service;

	@GetMapping
	//ResponseEntity  oggetto che contiene il dato e lo status code
	public ResponseEntity<List<Utente>> getAllUtenti() {
		//return userService.getAll(); -> solo il body della risposta
		//return new ResponseEntity(userService.getAll(), HttpStatus.OK); -> il body e lo status code della risposta 
		return ResponseEntity.ok(service.getAll()); // Metodo alternativo -> il body e lo status code della risposta
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUtenteById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}


	@PostMapping
	public ResponseEntity<?> createUtente(@RequestBody Utente utente) {
		return ResponseEntity.ok(service.createUtente(utente));

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUtente(@RequestBody Utente utente, @PathVariable Long id) {
		return ResponseEntity.ok(service.updateUtente(utente, id));

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUtente(@PathVariable Long id) {
		return ResponseEntity.ok(service.removeUtente(id));

	}
	
	
	


}
