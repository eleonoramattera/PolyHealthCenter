package PolyHealthCenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PolyHealthCenter.model.Sede;
import PolyHealthCenter.repository.SedeDAORepository;
import jakarta.persistence.EntityExistsException;

@Service
public class SedeService {
	
	@Autowired SedeDAORepository repo;
	
	public Sede getById(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityExistsException("Comune non esiste!!");
		}
		return repo.findById(id).get();
	}
	
	

}
