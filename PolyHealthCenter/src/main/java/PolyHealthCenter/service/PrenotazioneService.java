package PolyHealthCenter.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import PolyHealthCenter.repository.PrenotazioneDAORepository;


import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import PolyHealthCenter.model.Prenotazione;
import PolyHealthCenter.model.Terapia;
import PolyHealthCenter.model.Utente;
import PolyHealthCenter.exception.PrenotazioneException;

@Service
public class PrenotazioneService {
	@Autowired PrenotazioneDAORepository repo;

	
	
	
	
	
	public Prenotazione getPrenotazioneRandom() {
		return repo.findByPrenotazioneRandom();
	}
	//JPA METHODS

//getByID
public Prenotazione getById(Long id) {
	if (!repo.existsById(id)) {
		throw new EntityNotFoundException("Prenotazione non esiste!");
	}
	return repo.findById(id).get();
}


//getAll
public List<Prenotazione> getAll() {
	return repo.findAll();
}


//update
public Prenotazione updatePrenotazione( Prenotazione prenotazione, Long id) {
	Optional<Prenotazione> prenotazioneResult = repo.findById(id);
	
	if (prenotazioneResult.isPresent()) {
		Prenotazione prenotazioneUpdate = prenotazioneResult.get();
		prenotazioneUpdate.setDataPrenotazione(prenotazione.getDataPrenotazione());
		prenotazioneUpdate.setNomeTerapia(prenotazione.getNomeTerapia());
		//prenotazioneUpdate.setUtente(prenotazione.getUtente());
		prenotazioneUpdate.setSede(prenotazione.getSede());
		repo.save(prenotazioneUpdate);
		return prenotazioneUpdate;
	} else {
		throw new PrenotazioneException("Prenotazione non aggiornata");
	}



}

//delete

public String deletePrenotazione(Long id) {
	if(!repo.existsById(id)) {
		throw new EntityExistsException("La Prenotazione con id " + id + " non è presente del database!");
	}
	repo.deleteById(id);
	return "Prenotazione cancellata!!!";
}


//public Prenotazione salvaPrenotazione(PrenotazioneDTO DTO) {
//	if(repo.existsByNumeroPrenotazione(DTO.getNumeroPrenotazione())) {
//		throw new EntityExistsException("Prenotazione con numero prenotazione " + DTO.getNumeroPrenotazione() + " è già stata creata");
//	}
//	if(!repoUSer.existsByEmail(DTO.getEmailUser())) {
//		throw new MyAPIException(HttpStatus.NOT_FOUND, "Utente[" + DTO.getEmailUser() + "] non esiste");
//	}
//	if(!repoTerapia.existsByNome(DTO.getNomeTerapia())) {
//		throw new MyAPIException(HttpStatus.NOT_FOUND, "Terapia[" + DTO.getNomeTerapia() + "] non esiste");
//	}
//	if(!repoSede.existsByComune(DTO.getComune())) {
//		throw new MyAPIException(HttpStatus.NOT_FOUND, "Sede[" + DTO.getComune() + "] non esiste");
//	}
//	Prenotazione prenotazione =new Prenotazione();
//	//fattura.setCliente(repoCliente.findById(DTO.getEmailCliente()).get());
//	prenotazione.setDataPrenotazione(DTO.getDataPrenotazione());
//	prenotazione.setSede(repoSede.findByComune(DTO.getComune()));
//	prenotazione.setTerapia(repoTerapia.findByNome(DTO.getNomeTerapia()));
//	prenotazione.setUser(repoUSer.findByEmail(DTO.getEmailUser()));
//	prenotazione.setDataPrenotazione(DTO.getDataPrenotazione());
//
//	System.out.println(prenotazione);
//	repo.save(prenotazione);
//	
//	return prenotazione;
//	
//}

//create
public Prenotazione salva(Prenotazione prenotazione, String dateStringFromFrontend) {
	if(repo.existsById(prenotazione.getId())) {
		throw new EntityNotFoundException("id già presente");
	    }
	  return repo.save(prenotazione);
	}


public Prenotazione salvaPrenotazione(Prenotazione p) {
//	//List<Prenotazione> listaperUtente =  getByUtenteAndDataPrenotazione(p.getUtente(), p.getDataPrenotazione());
//	List<Prenotazione> listperTerapia = getByTerapiaAndDataPrenotazione(p.getTerapia(), p.getDataPrenotazione());
////	if (listaperUtente.size() > 0) {
//	// System.out.println("ATTENZIONE. ESISTE GIA UNA PRENOTAZIONE PER LA DATA RICHIESTA");
////	}
// if (listperTerapia.size() > 0 ) {
//		 System.out.println("ATTENZIONE. LA TERAPIA E' GIA OCCUPATA NELLA DATA RICHIESTA");			
//	} else {
//		System.out.println("Prenotazione aggiunta al DB!!!");
//	repo.save(p);
//	}
//	return p;
	if(repo.existsById(p.getId())) {
		throw new EntityNotFoundException("Prenotazione già presente");
	} 
	System.out.println("Prenotazizone con id " + p.getId() +  " inserita nel DB");
	return repo.save(p);
	
	
}


	


// CUSTOM METHODS
//public List<Prenotazione> getBytente(Utente u) {
//	return (List<Prenotazione>) repo.findByUtente(u);	
//}
//
//public List<Prenotazione> getByUtenteAndDataPrenotazione(Utente u, LocalDate data) {
//	return (List<Prenotazione>) repo.findByUtenteAndDataPrenotazione(u, data);	
//}
//public List<Prenotazione> getByTerapiaAndDataPrenotazione(Terapia t, LocalDate data) {
//	return (List<Prenotazione>) repo.findByTerapiaAndDataPrenotazione(t, data);	
//}


}
