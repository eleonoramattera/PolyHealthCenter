package PolyHealthCenter.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PolyHealthCenter.model.Prenotazione;
import PolyHealthCenter.model.Utente;
import PolyHealthCenter.model.Terapia;

@Repository
public interface PrenotazioneDAORepository  extends JpaRepository<Prenotazione, Long>{

	public List<Prenotazione> findByUtente(Utente utente);
	public List<Prenotazione> findByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);
	public List<Prenotazione> findByTerapiaAndDataPrenotazione(Terapia terapia, LocalDate dataPrenotazione);
}
