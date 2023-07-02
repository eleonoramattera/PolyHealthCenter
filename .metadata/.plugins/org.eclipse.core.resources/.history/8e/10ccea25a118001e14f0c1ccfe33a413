package PolyHealthCenter.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import PolyHealthCenter.repository.PrenotazioneDAORepository;
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

//create
//public Prenotazione createPrenotazione(Prenotazione postazione) {
//	return repo.save(postazione);
//}

//update
public Prenotazione updatePrenotazione(Long id, Prenotazione prenotazione) {
	Optional<Prenotazione> prenotazioneResult = repo.findById(id);

	if (prenotazioneResult.isPresent()) {
		Prenotazione prenotazioneUpdate = prenotazioneResult.get();
		prenotazioneUpdate.setDataPrenotazione(prenotazione.getDataPrenotazione());
		prenotazioneUpdate.setTerapia(prenotazione.getTerapia());
		prenotazioneUpdate.setUtente(prenotazione.getUtente());
		prenotazioneUpdate.setSede(prenotazione.getSede());
		repo.save(prenotazioneUpdate);
		return prenotazioneUpdate;
	} else {
		throw new PrenotazioneException("Prenotazione non aggiornata");
	}

}

//delete
public void deletePrenotazione(Long id) {
	repo.deleteById(id);
}

//create
public void salvaPrenotazione(Prenotazione p) {
	List<Prenotazione> listaperUtente =  getByUtenteAndDataPrenotazione(p.getUtente(), p.getDataPrenotazione());
	List<Prenotazione> listperTerapia = getByTerapiaAndDataPrenotazione(p.getTerapia(), p.getDataPrenotazione());
	if (listaperUtente.size() > 0) {
	 System.out.println("ATTENZIONE. ESISTE GIA UNA PRENOTAZIONE PER LA DATA RICHIESTA");
	} else if (listperTerapia.size() > 0 ) {
		 System.out.println("ATTENZIONE. LA TERAPIA E' GIA OCCUPATA NELLA DATA RICHIESTA");			
	} else {
	repo.save(p);
	 System.out.println("Prenotazione aggiunta al DB!!!");
	}
}


// CUSTOM METHODS
public List<Prenotazione> getByUtente(Utente u) {
	return (List<Prenotazione>) repo.findByUtente(u);	
}

public List<Prenotazione> getByUtenteAndDataPrenotazione(Utente u, LocalDate data) {
	return (List<Prenotazione>) repo.findByUtenteAndDataPrenotazione(u, data);	
}
public List<Prenotazione> getByTerapiaAndDataPrenotazione(Terapia t, LocalDate data) {
	return (List<Prenotazione>) repo.findByTerapiaAndDataPrenotazione(t, data);	
}


}
