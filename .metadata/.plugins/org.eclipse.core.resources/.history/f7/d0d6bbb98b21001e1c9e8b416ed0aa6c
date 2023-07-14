package PolyHealthCenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import PolyHealthCenter.model.Prenotazione;
import PolyHealthCenter.service.PrenotazioneService;

@CrossOrigin(origins =  "*", maxAge = 360000)
@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {
	
	@Autowired private PrenotazioneService service;

	@GetMapping
	@PreAuthorize("isAuthenticated()")
	//ResponseEntity  oggetto che contiene il dato e lo status code
	public ResponseEntity<List<Prenotazione>> getAllPrenotazioni() {
		//return userService.getAll(); -> solo il body della risposta
		//return new ResponseEntity(userService.getAll(), HttpStatus.OK); -> il body e lo status code della risposta 
		return ResponseEntity.ok(service.getAll()); // Metodo alternativo -> il body e lo status code della risposta
	}

	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getPrenotazioneById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}
	
	
	@PostMapping
	@PreAuthorize("hasRole('USER', 'ADMIN')")
	public ResponseEntity<?> createPrentazione(@RequestBody Prenotazione prenotazione) {
		return new ResponseEntity<Prenotazione>(service.salvaPrenotazione(prenotazione), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('USER', 'ADMIN')")
	public ResponseEntity<?> updatePrenotazione(@RequestBody Prenotazione prenotazione, @PathVariable Long id) {
		return ResponseEntity.ok(service.updatePrenotazione(prenotazione, id));

	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('USER', 'ADMIN')")
	public ResponseEntity<String> deleteVacanza(@PathVariable Long id){
		return new ResponseEntity<String>(service.deletePrenotazione(id), HttpStatus.OK);
	}

	
	
	
}
