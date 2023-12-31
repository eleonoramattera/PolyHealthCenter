package PolyHealthCenter.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import PolyHealthCenter.model.Utente;
import PolyHealthCenter.repository.UtenteDAORepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UtenteService {
	
	@Autowired UtenteDAORepository repo;
	@Autowired @Qualifier("FakeUtenteBean") ObjectProvider<Utente> utenteFakeProvider;
	
	public void createFakeUtente() {
		Utente u = utenteFakeProvider.getObject();
		createUtente(u);
	}
	
	public Utente getUtenteRandom() {
		return repo.findByUtenteRandom();
	}
	//JPA METHODS
	
	// getAll
	public List<Utente> getAll() {
	 return  repo.findAll();
    }
	
	//getByID
	public Utente getById(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityNotFoundException("Utente non esiste!");
		}
		return repo.findById(id).get();
	}
	
	//create
	public Utente createUtente(Utente utente) {
	 // Gestione di un errore | email già presente
	 if(repo.existsByEmail(utente.getEmail()) || repo.existsByNumeroTelefono(utente.getNumeroTelefono())) {
		throw new EntityNotFoundException("email/numero di telefono già presente");
	    }
	 
	 System.out.println("Utente " + utente.getNome() + " " + utente.getCognome() + " inserito nel DB");
		return repo.save(utente);
	}
	
	
	
	//update
	public Utente updateUtente(Utente utente, Long id) {
		if (repo.existsById(id)) {
			throw new EntityExistsException(" Utente [id:" + utente.getId() + "] non esiste");
		}
		repo.save(utente);
		return utente;
	}
	
	
	//remove
	public String removeUtente(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityExistsException("Utente not found");
		}
		repo.deleteById(id);
		return "Utente cancellato!";
	}
	
	//CUSTOM METHODS

	public Utente getByEmail(String email) {
		return repo.findByEmail(email);
	}
  
	public Utente getByNumeroTelefono(String numeroTelefono) {
		return repo.findByNumeroTelefono(numeroTelefono);
	}

	
	
	
	


	
}
