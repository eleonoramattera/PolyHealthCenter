package PolyHealthCenter.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import PolyHealthCenter.service.SedeService;

@RestController
@RequestMapping("/api/comuni")
public class SedeController {
	
    @Autowired SedeService service;
    
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById (@PathVariable Long id){
		return ResponseEntity.ok(service.getById(id));
	}
	

}
