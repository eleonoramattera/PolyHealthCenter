package PolyHealthCenter.controller;



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

import PolyHealthCenter.model.Sede;
import PolyHealthCenter.service.SedeService;

@RestController
@RequestMapping("/api/comuni")
public class SedeController {
	
    @Autowired SedeService service;
    
    @GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById (@PathVariable Long id){
		return ResponseEntity.ok(service.getById(id));
	}
	
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> save(@RequestBody Sede sede) {
		return ResponseEntity.ok(service.createSede(sede));
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Sede sede) {
		return ResponseEntity.ok(service.updateSede(sede, id));
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		return ResponseEntity.ok(service.removeSede(id));
	}


}
