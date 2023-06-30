package PolyHealthCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import PolyHealthCenter.model.Utente;

@Repository
public interface UtenteDAORepository extends JpaRepository<Utente, Long>  {
	
	public boolean existsByEmail(String email);
	public boolean existsByNumeroTelefono(String numeroTelefono);
	
	public Utente findByEmail(String email);
	public Utente findByNumeroTelefono(String numeroTelefono);

	@Query(value="SELECT u FROM Utente u ORDER BY RANDOM() LIMIT 1")
	Utente findByUtenteRandom();
	
}
