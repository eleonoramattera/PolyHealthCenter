package PolyHealthCenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PolyHealthCenter.model.Feedback;
import PolyHealthCenter.model.Prenotazione;
import PolyHealthCenter.model.Sede;
import PolyHealthCenter.repository.SedeDAORepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SedeService {
	
	@Autowired SedeDAORepository repo;
	
	//getBYID
	public Sede getById(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityExistsException("Comune non esiste!!");
		}
		return repo.findById(id).get();
	}
	
	//getAll
	public List<Sede> getAll() {
		return repo.findAll();
	}
	
	//create
		public Sede createSede(Sede sede) {
	    // Gestione di un errore | comune già presente
		  if(repo.existsByComune(sede.getComune()) ) {
			throw new EntityNotFoundException(" la sede nella città di " + sede.getComune() +  " è già presente");
			  }
		  System.out.println("Sede inserita nel DB");
		  return repo.save(sede);
		}

		
		
		//update
		public Sede updateSede(Sede sede, Long id) {
		  if (repo.existsById(id)) {
			throw new EntityExistsException(" Sede [id:" + sede.getId() + "] non esiste");
				}
			repo.save(sede);
			return sede;
			}
			
			
		//remove
		public String removeSede(Long id) {
		   if (!repo.existsById(id)) {
			 throw new EntityExistsException("Sede con id " + id + " non è presente nel DB");
		   }
			repo.deleteById(id);
			return "Sede cancellata!";
			}
	

}
