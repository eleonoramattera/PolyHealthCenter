package PolyHealthCenter.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

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

import PolyHealthCenter.model.Feedback;
import PolyHealthCenter.model.Utente;
import PolyHealthCenter.service.FeedbackService;

@CrossOrigin(origins =  "*", maxAge = 360000)
@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
	
	@Autowired private FeedbackService service;

	
	@GetMapping
	//ResponseEntity  oggetto che contiene il dato e lo status code
	public ResponseEntity<List<Feedback>> getAllFeedback() {
		//return userService.getAll(); -> solo il body della risposta
		//return new ResponseEntity(userService.getAll(), HttpStatus.OK); -> il body e lo status code della risposta 
		return ResponseEntity.ok(service.getAll()); // Metodo alternativo -> il body e lo status code della risposta
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getFeedbackById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createFeedback(@RequestBody Feedback feedback) {
		return ResponseEntity.ok(service.createFeedback(feedback));

	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateFeedback(@RequestBody Feedback feedback, @PathVariable Long id) {
		return ResponseEntity.ok(service.updateFeedback(feedback, id));

	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteFeedback(@PathVariable Long id) {
		return ResponseEntity.ok(service.removeFeedback(id));

	}
	
}
