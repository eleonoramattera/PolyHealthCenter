package PolyHealthCenter.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import PolyHealthCenter.model.Terapia;
import PolyHealthCenter.model.Utente;
import PolyHealthCenter.repository.TerapiaDAORepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;


@Service
public class TerapiaService {
	@Autowired TerapiaDAORepository repo;
@Autowired @Qualifier("FakeTerapiaBean") ObjectProvider<Terapia> terapiaFakeProvider;
	
	public void createFakeTerapia() {
		Terapia t = terapiaFakeProvider.getObject();
		createTerapia(t);
	}
	
	public Terapia getTerapiaRandom() {
		return repo.findByTerapiaRandom();
	}

	//JPA METHODS
	// getAll
	public List<Terapia> getAll(){
		return repo.findAll();
		
	}
	
	//getByID
	public Terapia getById(Long id) {
	  if (!repo.existsById(id)) {
		throw new EntityNotFoundException("Terapia non esiste!");
		}
		return repo.findById(id).get();
		}
	
		
	//create
	public Terapia createTerapia(Terapia terapia) {
	// Gestione di un errore |  nome presente
	 if(repo.existsByNome(terapia.getNome())) {
		throw new EntityNotFoundException("Nome già presente");
		 }
	 System.out.println("Terapia " + terapia.getNome() +  " inserita nel DB");
		return repo.save(terapia);
		}
		
	
	//update
	public Terapia updateTerapia(Terapia terapia, Long id) {
	  if (repo.existsById(id)) {
		throw new EntityExistsException(" Utente [id:" + terapia.getId() + "] non esiste");
		}
		repo.save(terapia);
		return terapia;
		}
		
		
	//remove
	public String removeTerapia(Long id) {
	  if (!repo.existsById(id)) {
		throw new EntityExistsException("Terapia not found");
		}
		repo.deleteById(id);
		return "Terapia cancellata!";
		}


		
}
